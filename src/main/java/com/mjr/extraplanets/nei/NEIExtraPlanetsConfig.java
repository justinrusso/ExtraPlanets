package com.mjr.extraplanets.nei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.nei.machines.BlockSmasherRecipeHandler;
import com.mjr.extraplanets.nei.machines.CircuitFabricatorRecipeHandler;
import com.mjr.extraplanets.nei.machines.CrystallizerRecipeHandler;
import com.mjr.extraplanets.nei.machines.DecrystallizerRecipeHandler;
import com.mjr.extraplanets.nei.machines.SolarEvaporationChamberHandler;
import com.mjr.extraplanets.nei.rockets.RocketT10RecipeHandler;
import com.mjr.extraplanets.nei.rockets.RocketT4RecipeHandler;
import com.mjr.extraplanets.nei.rockets.RocketT5RecipeHandler;
import com.mjr.extraplanets.nei.rockets.RocketT6RecipeHandler;
import com.mjr.extraplanets.nei.rockets.RocketT7RecipeHandler;
import com.mjr.extraplanets.nei.rockets.RocketT8RecipeHandler;
import com.mjr.extraplanets.nei.rockets.RocketT9RecipeHandler;

public class NEIExtraPlanetsConfig implements IConfigureNEI {
	// Tier 4 - 10 Rockets
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t4rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t5rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t6rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t7rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t8rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t9rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();
	private static HashMap<ArrayList<PositionedStack>, PositionedStack> t10rocketBenchRecipes = new HashMap<ArrayList<PositionedStack>, PositionedStack>();

	// GC Machines
	private static HashMap<HashMap<Integer, PositionedStack>, PositionedStack> circuitFabricatorRecipes = new HashMap<HashMap<Integer, PositionedStack>, PositionedStack>();

	// Custom Machines
	private static HashMap<PositionedStack, PositionedStack> blockSmasherRecipes = new HashMap<PositionedStack, PositionedStack>();
	private static HashMap<PositionedStack, PositionedStack> crystallizerRecipes = new HashMap<PositionedStack, PositionedStack>();
	private static HashMap<PositionedStack, PositionedStack> decrystallizerRecipes = new HashMap<PositionedStack, PositionedStack>();
	private static HashMap<PositionedStack, PositionedStack> chemicalInjectorRecipes = new HashMap<PositionedStack, PositionedStack>();
	private static HashMap<PositionedStack, PositionedStack> solarEvaporationChamberRecipes = new HashMap<PositionedStack, PositionedStack>();

	@Override
	public void loadConfig() {
		if (Config.neiSupport) {
			this.registerCustomMachinesRecipes();
			if (Config.mercury)
				this.registerTier4Recipe();
			if (Config.jupiter)
				this.registerTier5Recipe();
			if (Config.saturn)
				this.registerTier6Recipe();
			if (Config.uranus)
				this.registerTier7Recipe();
			if (Config.neptune)
				this.registerTier8Recipe();
			if (Config.pluto)
				this.registerTier9Recipe();
			if (Config.eris)
				this.registerTier10Recipe();
			this.addCircuitFabricatorRecipes();

			if (Config.mercury) {
				API.registerRecipeHandler(new RocketT4RecipeHandler());
				API.registerUsageHandler(new RocketT4RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.mercurySpawner));
			}
			if (Config.jupiter) {
				API.registerRecipeHandler(new RocketT5RecipeHandler());
				API.registerUsageHandler(new RocketT5RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.jupiterSpawner));
			}
			if (Config.saturn) {
				API.registerRecipeHandler(new RocketT6RecipeHandler());
				API.registerUsageHandler(new RocketT6RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.saturnSpawner));
			}
			if (Config.uranus) {
				API.registerRecipeHandler(new RocketT7RecipeHandler());
				API.registerUsageHandler(new RocketT7RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.uranusSpawner));
			}
			if (Config.neptune) {
				API.registerRecipeHandler(new RocketT8RecipeHandler());
				API.registerUsageHandler(new RocketT8RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.neptuneSpawner));
			}
			if (Config.pluto) {
				API.registerRecipeHandler(new RocketT9RecipeHandler());
				API.registerUsageHandler(new RocketT9RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.plutoSpawner));
			}
			if (Config.eris) {
				API.registerRecipeHandler(new RocketT10RecipeHandler());
				API.registerUsageHandler(new RocketT10RecipeHandler());
				API.hideItem(new ItemStack(ExtraPlanets_Blocks.erisSpawner));
			}
			API.registerRecipeHandler(new CircuitFabricatorRecipeHandler());
			API.registerUsageHandler(new CircuitFabricatorRecipeHandler());

			if (Config.basicSmasher) {
				API.registerRecipeHandler(new BlockSmasherRecipeHandler());
				API.registerUsageHandler(new BlockSmasherRecipeHandler());
			}
			if (Config.basicCrystallizer) {
				API.registerRecipeHandler(new CrystallizerRecipeHandler());
				API.registerUsageHandler(new CrystallizerRecipeHandler());
			}
			if (Config.basicDecrystallizer) {
				API.registerRecipeHandler(new DecrystallizerRecipeHandler());
				API.registerUsageHandler(new DecrystallizerRecipeHandler());
			}
			if (Config.basicChemicalInjector) {
				API.registerRecipeHandler(new SolarEvaporationChamberHandler());
				API.registerUsageHandler(new SolarEvaporationChamberHandler());
			}
		}
	}

	@Override
	public String getName() {
		return "ExtraPlanets NEI Plugin";
	}

	@Override
	public String getVersion() {
		return Constants.LOCALMAJVERSION + "." + Constants.LOCALMINVERSION + "." + Constants.LOCALBUILDVERSION;
	}

	public void registerTier4RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t4rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier4RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t4rocketBenchRecipes.entrySet();
	}

	public void registerTier5RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t5rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier5RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t5rocketBenchRecipes.entrySet();
	}

	public void registerTier6RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t6rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier6RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t6rocketBenchRecipes.entrySet();
	}

	public void registerTier7RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t7rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier7RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t7rocketBenchRecipes.entrySet();
	}

	public void registerTier8RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t8rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier8RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t8rocketBenchRecipes.entrySet();
	}

	public void registerTier9RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t9rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier9RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t9rocketBenchRecipes.entrySet();
	}

	public void registerTier10RocketBenchRecipe(ArrayList<PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.t10rocketBenchRecipes.put(input, output);
	}

	public static Set<Map.Entry<ArrayList<PositionedStack>, PositionedStack>> getTier10RocketBenchRecipes() {
		return NEIExtraPlanetsConfig.t10rocketBenchRecipes.entrySet();
	}

	public void registerCircuitFabricatorRecipe(HashMap<Integer, PositionedStack> input, PositionedStack output) {
		NEIExtraPlanetsConfig.circuitFabricatorRecipes.put(input, output);
	}

	public static Set<Entry<HashMap<Integer, PositionedStack>, PositionedStack>> getCircuitFabricatorRecipes() {
		return NEIExtraPlanetsConfig.circuitFabricatorRecipes.entrySet();
	}

	public void registerBlockSmasherRecipe(PositionedStack input, PositionedStack output) {
		NEIExtraPlanetsConfig.blockSmasherRecipes.put(input, output);
	}

	public static Set<Entry<PositionedStack, PositionedStack>> getBlockSmasherRecipes() {
		return NEIExtraPlanetsConfig.blockSmasherRecipes.entrySet();
	}

	public void registerCrystallizerRecipe(PositionedStack input, PositionedStack output) {
		NEIExtraPlanetsConfig.crystallizerRecipes.put(input, output);
	}

	public static Set<Entry<PositionedStack, PositionedStack>> getCrystallizerRecipes() {
		return NEIExtraPlanetsConfig.crystallizerRecipes.entrySet();
	}

	public void registerDecrystallizerRecipe(PositionedStack input, PositionedStack output) {
		NEIExtraPlanetsConfig.decrystallizerRecipes.put(input, output);
	}

	public static Set<Entry<PositionedStack, PositionedStack>> getDecrystallizerRecipes() {
		return NEIExtraPlanetsConfig.decrystallizerRecipes.entrySet();
	}

	public void registerChemicalInjectorRecipe(PositionedStack input, PositionedStack output) {
		NEIExtraPlanetsConfig.chemicalInjectorRecipes.put(input, output);
	}

	public static Set<Entry<PositionedStack, PositionedStack>> getChemicalInjectorRecipes() {
		return NEIExtraPlanetsConfig.decrystallizerRecipes.entrySet();
	}

	public void registerSolarEvaporationChamberRecipe(PositionedStack input, PositionedStack output) {
		NEIExtraPlanetsConfig.solarEvaporationChamberRecipes.put(input, output);
	}

	public static Set<Entry<PositionedStack, PositionedStack>> getSolarEvaporationChamberRecipes() {
		return NEIExtraPlanetsConfig.solarEvaporationChamberRecipes.entrySet();
	}

	private void registerCustomMachinesRecipes() {
		this.registerBlockSmasherRecipe(new PositionedStack(new ItemStack(ExtraPlanets_Blocks.potash, 1, 0), 45, 31), new PositionedStack(new ItemStack(ExtraPlanets_Items.potash, 3, 0), 107, 31));
		this.registerCrystallizerRecipe(new PositionedStack(new ItemStack(ExtraPlanets_Items.salt_bucket, 1, 0), 2, 3), new PositionedStack(new ItemStack(ExtraPlanets_Items.iodideSalt, 6, 0), 107, 31));
		this.registerDecrystallizerRecipe(new PositionedStack(new ItemStack(ExtraPlanets_Items.iodideSalt, 6, 0), 77, 31), new PositionedStack(new ItemStack(ExtraPlanets_Items.salt_bucket, 1, 0), 148, 3));
		this.registerSolarEvaporationChamberRecipe(new PositionedStack(new ItemStack(ExtraPlanets_Items.potash, 12, 0), 45, 31), new PositionedStack(new ItemStack(ExtraPlanets_Items.potassium), 107, 31));
	}

	public void registerTier4Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier4), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 2), 72, 100 + changeY));
		this.registerTier4RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier4RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier5Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier5), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 2), 72, 100 + changeY));
		this.registerTier5RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier5RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier6Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier6), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Items, 1, 2), 72, 100 + changeY));
		this.registerTier6RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier6RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier6Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier7Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier7), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 2), 72, 100 + changeY));
		this.registerTier7RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier7RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier8Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier8), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 2), 72, 100 + changeY));
		this.registerTier8RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier8RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier9Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier9), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Items, 1, 2), 72, 100 + changeY));
		this.registerTier9RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier9RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier9Rocket, 1, 3), 139, 87 + changeY));
	}

	public void registerTier10Recipe() {
		final int changeY = 15;

		ArrayList<PositionedStack> input1 = new ArrayList<PositionedStack>();

		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.noseConeTier10), 45, -8 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 3), 36, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 3), 36, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 3), 36, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 3), 36, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 3), 36, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 3), 54, -6 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 3), 54, -6 + 18 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 3), 54, -6 + 36 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 3), 54, -6 + 54 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 3), 54, -6 + 72 + 16 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 0), 45, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 1), 18, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 1), 72, 64 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 2), 18, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 2), 18, 100 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 2), 72, 82 + changeY));
		input1.add(new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Items, 1, 2), 72, 100 + changeY));
		this.registerTier10RocketBenchRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Rocket, 1, 0), 139, 87 + changeY));

		ArrayList<PositionedStack> input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Rocket, 1, 1), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Rocket, 1, 2), 139, 87 + changeY));

		input2 = new ArrayList<PositionedStack>(input1);
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 26, -15 + changeY));
		input2.add(new PositionedStack(new ItemStack(Blocks.chest), 90 + 52, -15 + changeY));
		this.registerTier10RocketBenchRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier10Rocket, 1, 3), 139, 87 + changeY));
	}

	private void addCircuitFabricatorRecipes() {
		HashMap<Integer, PositionedStack> input1 = new HashMap<Integer, PositionedStack>();
		int siliconCount = OreDictionary.getOres(ConfigManagerCore.otherModsSilicon).size();
		ItemStack[] silicons = new ItemStack[siliconCount + 1];
		silicons[0] = new ItemStack(GCItems.basicItem, 1, 2);
		for (int j = 0; j < siliconCount; j++) {
			silicons[j + 1] = OreDictionary.getOres(ConfigManagerCore.otherModsSilicon).get(j);
		}
		input1.put(1, new PositionedStack(silicons, 69, 51));
		input1.put(2, new PositionedStack(silicons, 69, 69));
		input1.put(3, new PositionedStack(new ItemStack(Items.redstone), 117, 51));

		// Diamond
		input1.put(0, new PositionedStack(new ItemStack(Items.diamond), 10, 22));
		input1.put(4, new PositionedStack(new ItemStack(Blocks.redstone_lamp), 140, 25));
		this.registerCircuitFabricatorRecipe(input1, new PositionedStack(new ItemStack(ExtraPlanets_Items.wafers, 3, 0), 147, 91));

		// Carbon
		HashMap<Integer, PositionedStack> input2 = new HashMap<Integer, PositionedStack>(input1);
		if (Config.mercury) {
			input2.put(0, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier4Items, 1, 5), 10, 22));
			input2.put(4, new PositionedStack(new ItemStack(Items.comparator), 140, 25));
			this.registerCircuitFabricatorRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.wafers, 3, 1), 147, 91));
		}
		// Titanium
		input2 = new HashMap<Integer, PositionedStack>(input1);
		input2.put(0, new PositionedStack(new ItemStack(AsteroidsItems.basicItem, 1, 5), 10, 22));
		input2.put(4, new PositionedStack(new ItemStack(Blocks.redstone_torch), 140, 25));
		this.registerCircuitFabricatorRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.wafers, 3, 2), 147, 91));

		if (Config.jupiter) {
			// Red Gem
			input2 = new HashMap<Integer, PositionedStack>(input1);
			input2.put(0, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier5Items, 1, 8), 10, 22));
			input2.put(4, new PositionedStack(new ItemStack(Items.repeater), 140, 25));
			this.registerCircuitFabricatorRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.wafers, 3, 3), 147, 91));
		}
		if (Config.neptune) {
			// Blue Gem
			input2 = new HashMap<Integer, PositionedStack>(input1);
			input2.put(0, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier8Items, 1, 6), 10, 22));
			input2.put(4, new PositionedStack(new ItemStack(Items.repeater), 140, 25));
			this.registerCircuitFabricatorRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.wafers, 3, 4), 147, 91));
		}
		if (Config.uranus) {
			// White Gem
			input2 = new HashMap<Integer, PositionedStack>(input1);
			input2.put(0, new PositionedStack(new ItemStack(ExtraPlanets_Items.tier7Items, 1, 7), 10, 22));
			input2.put(4, new PositionedStack(new ItemStack(Items.repeater), 140, 25));
			this.registerCircuitFabricatorRecipe(input2, new PositionedStack(new ItemStack(ExtraPlanets_Items.wafers, 3, 5), 147, 91));
		}
	}

}