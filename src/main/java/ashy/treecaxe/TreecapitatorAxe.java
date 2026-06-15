package ashy.treecaxe;

import net.minecraft.core.data.gamerule.TreecapitatorHelper;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemToolAxe;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;


public class TreecapitatorAxe extends ItemToolAxe {
	public static final ToolMaterial TREECAPITATOR_STEEL = new ToolMaterial()
		.setDurability(450)
		.setMiningLevel(3)
		.setEfficiency(4.0F, 10.0F)
		.setDamage(1);

	public TreecapitatorAxe(String translationKey, String namespaceId, int itemId) {
		super(translationKey, namespaceId, itemId, TREECAPITATOR_STEEL);
	}

	@Override
	public boolean beforeDestroyBlock(
		World world,
		ItemStack itemStack,
		int blockId,
		int x,
		int y,
		int z,
		Side side,
		Player player
	) {
		if (!world.isClientSide) {
			boolean chopped = new TreecapitatorHelper(world, x, y, z, player).chopTree();

			if (chopped) {
				itemStack.damageItem(1, player);

				return false;
			}
		}

		return super.beforeDestroyBlock(
			world,
			itemStack,
			blockId,
			x,
			y,
			z,
			side,
			player
		);
	}
}
