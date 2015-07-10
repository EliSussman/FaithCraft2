package FaithCraft2.Common.common.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class AltarRecipeSorter implements Comparator{

	final AltarCraftingManager altar;
	
	public AltarRecipeSorter(AltarCraftingManager altarCraftingManager){
		this.altar = altarCraftingManager;
	}
	
	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2){
		return irecipe1 instanceof AltarShapelessRecipes && irecipe2 instanceof AltarShapedRecipes ? 1: (irecipe2 instanceof AltarShapelessRecipes && irecipe1 instanceof AltarShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}