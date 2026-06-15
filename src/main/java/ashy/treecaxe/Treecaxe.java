package ashy.treecaxe;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemToolAxe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class Treecaxe implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint {
	public static final String MOD_ID = "treecaxe";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Item TreecaxeItem;
	ItemBuilder GenericItemBuilder = new ItemBuilder((Treecaxe.MOD_ID));
	@Override
	public void onInitialize() {
		LOGGER.info("ExampleMod initialized.");
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}

	@Override
	public void beforeGameStart() {
		TreecaxeItem = GenericItemBuilder.build(new TreecapitatorAxe("TreecapitatorAxe", Treecaxe.MOD_ID + ":TreecapitatorAxe", 30000));

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {
		ItemStack treecaxeResult = new ItemStack(TreecaxeItem, 1, 0);
		RecipeBuilder.Shaped("treecaxe")
			.setShape("LLL", "LAL", "LLL")
			.addInput('L', Blocks.LOG_OAK)
			.addInput('A', Items.TOOL_AXE_STEEL)
			.create("treecaxe", treecaxeResult);
	}
}
