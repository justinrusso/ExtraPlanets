package com.mjr.extraplanets.planets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.util.ResourceLocation;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets_SolarSystems;
import com.mjr.extraplanets.planets.Ceres.TeleportTypeCeres;
import com.mjr.extraplanets.planets.Ceres.WorldProviderCeres;
import com.mjr.extraplanets.planets.Eris.TeleportTypeEris;
import com.mjr.extraplanets.planets.Eris.WorldProviderEris;
import com.mjr.extraplanets.planets.Jupiter.TeleportTypeJupiter;
import com.mjr.extraplanets.planets.Jupiter.WorldProviderJupiter;
import com.mjr.extraplanets.planets.Kepler22b.TeleportTypeKepler22b;
import com.mjr.extraplanets.planets.Kepler22b.WorldProviderKepler22b;
import com.mjr.extraplanets.planets.Mercury.TeleportTypeMercury;
import com.mjr.extraplanets.planets.Mercury.WorldProviderMercury;
import com.mjr.extraplanets.planets.Neptune.TeleportTypeNeptune;
import com.mjr.extraplanets.planets.Neptune.WorldProviderNeptune;
import com.mjr.extraplanets.planets.Pluto.TeleportTypePluto;
import com.mjr.extraplanets.planets.Pluto.WorldProviderPluto;
import com.mjr.extraplanets.planets.Saturn.TeleportTypeSaturn;
import com.mjr.extraplanets.planets.Saturn.WorldProviderSaturn;
import com.mjr.extraplanets.planets.Uranus.TeleportTypeUranus;
import com.mjr.extraplanets.planets.Uranus.WorldProviderUranus;
import com.mjr.extraplanets.planets.Venus.TeleportTypeVenus;
import com.mjr.extraplanets.planets.Venus.WorldProviderVenus;
import com.mjr.extraplanets.util.RegisterHelper;

public class ExtraPlanets_Planets {
	public static Planet mercury;
	public static Planet venus;
	public static Planet ceres;
	public static Planet jupiter;
	public static Planet saturn;
	public static Planet uranus;
	public static Planet neptune;
	public static Planet pluto;
	public static Planet haumea;
	public static Planet eris;
	public static Planet kuiperBelt;
	public static Planet makemake;

	public static Planet kepler22b;

	public static Planet kepler47b;
	public static Planet kepler47c;

	public static Planet kepler62b;
	public static Planet kepler62c;
	public static Planet kepler62d;
	public static Planet kepler62e;
	public static Planet kepler62f;

	public static Planet kepler69b;
	public static Planet kepler69c;

	public static void init() {
		initializePlanets();
		registerPlanets();
	}

	private static void initializePlanets() {
		if (Config.mercury) {
			mercury = new Planet("Mercury").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			mercury.setTierRequired(Config.mercuryRocketTier);
			mercury.setRingColorRGB(0.1F, 0.9F, 0.6F);
			mercury.setPhaseShift(1.45F);
			mercury.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F + Config.mercuryDistanceOffset, 0.5F + Config.mercuryDistanceOffset));
			mercury.setRelativeOrbitTime(0.24096385542168674698795180722892F);
			mercury.atmosphereComponent(IAtmosphericGas.HYDROGEN);
			mercury.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/mercury.png"));
			mercury.setDimensionInfo(Config.mercuryID, WorldProviderMercury.class);
		}
		if (Config.venus) {
			venus = new Planet("Venus").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			venus.setTierRequired(3);
			venus.setRingColorRGB(0.1F, 0.9F, 0.6F);
			venus.setPhaseShift(2.0F);
			venus.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.75F + Config.venusDistanceOffset, 0.75F + Config.venusDistanceOffset));
			venus.setRelativeOrbitTime(0.61527929901423877327491785323111F);
			venus.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.CO2);
			venus.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/venus.png"));
			venus.setDimensionInfo(Config.venusID, WorldProviderVenus.class);
		}
		if (Config.ceres) {
			ceres = new Planet("Ceres").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			ceres.setTierRequired(Config.ceresRocketTier);
			ceres.setRingColorRGB(0.1F, 0.9F, 0.6F);
			ceres.setPhaseShift(Constants.floatPI);
			ceres.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.50F + Config.ceresDistanceOffset, 1.50F + Config.ceresDistanceOffset));
			ceres.setRelativeOrbitTime((float) 11.861993428258488499452354874042 / 2);
			ceres.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM);
			ceres.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/ceres.png"));
			ceres.setDimensionInfo(Config.ceresID, WorldProviderCeres.class);
		}
		if (Config.jupiter) {
			jupiter = new Planet("Jupiter").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			jupiter.setTierRequired(4);
			jupiter.setRingColorRGB(0.1F, 0.9F, 0.6F);
			jupiter.setPhaseShift(Constants.floatPI);
			jupiter.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.75F + Config.jupiterDistanceOffset, 1.75F + Config.jupiterDistanceOffset));
			jupiter.setRelativeOrbitTime(11.861993428258488499452354874042F);
			jupiter.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM);
			jupiter.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/jupiter.png"));
			jupiter.setDimensionInfo(Config.jupiterID, WorldProviderJupiter.class);
		}
		if (Config.saturn) {
			saturn = new Planet("Saturn").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			if (Config.morePlanetsCompatibilityAdv)
				saturn.setTierRequired(4);
			else
				saturn.setTierRequired(5);
			saturn.setRingColorRGB(0.1F, 0.9F, 0.6F);
			saturn.setPhaseShift(5.45F);
			saturn.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.00F + Config.saturnDistanceOffset, 2.00F + Config.saturnDistanceOffset));
			saturn.setRelativeOrbitTime(29.463307776560788608981380065717F);
			saturn.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);
			saturn.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/saturn.png"));
			saturn.setDimensionInfo(Config.saturnID, WorldProviderSaturn.class);
		}
		if (Config.uranus) {
			uranus = new Planet("Uranus").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			if (Config.morePlanetsCompatibilityAdv)
				uranus.setTierRequired(4);
			else
				uranus.setTierRequired(6);
			uranus.setRingColorRGB(0.1F, 0.9F, 0.6F);
			uranus.setPhaseShift(1.38F);
			uranus.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.25F + Config.uranusDistanceOffset, 2.25F + Config.uranusDistanceOffset));
			uranus.setRelativeOrbitTime(84.063526834611171960569550930997F);
			uranus.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE).atmosphereComponent(IAtmosphericGas.WATER);
			uranus.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/uranus.png"));
			uranus.setDimensionInfo(Config.uranusID, WorldProviderUranus.class);
		}
		if (Config.neptune) {
			neptune = new Planet("Neptune").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			if (Config.morePlanetsCompatibilityAdv)
				neptune.setTierRequired(5);
			else
				neptune.setTierRequired(7);
			neptune.setRingColorRGB(0.1F, 0.9F, 0.6F);
			neptune.setPhaseShift(1.0F);
			neptune.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.50F + Config.neptuneDistanceOffset, 2.50F + Config.neptuneDistanceOffset));
			neptune.setRelativeOrbitTime(164.84118291347207009857612267251F);
			neptune.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.WATER);
			neptune.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/neptune.png"));
			neptune.setDimensionInfo(Config.neptuneID, WorldProviderNeptune.class);
		}
		if (Config.pluto) {
			pluto = new Planet("Pluto").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			pluto.setTierRequired(8);
			pluto.setRingColorRGB(0.1F, 0.9F, 0.6F);
			pluto.setPhaseShift(2.0F);
			pluto.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.75F + Config.plutoDistanceOffset, 2.75F + Config.plutoDistanceOffset));
			pluto.setRelativeOrbitTime((float) (164.84118291347207009857612267251 * 2));
			pluto.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.WATER);
			pluto.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/pluto.png"));
			pluto.setDimensionInfo(Config.plutoID, WorldProviderPluto.class);
		}
		if (Config.eris) {
			eris = new Planet("Eris").setParentSolarSystem(GalacticraftCore.solarSystemSol);
			if (Config.morePlanetsCompatibilityAdv)
				eris.setTierRequired(6);
			else
				eris.setTierRequired(9);
			eris.setRingColorRGB(0.1F, 0.9F, 0.6F);
			eris.setPhaseShift(1.0F);
			eris.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.50F + Config.erisDistanceOffset, 3.50F + Config.erisDistanceOffset));
			eris.setRelativeOrbitTime((float) (164.84118291347207009857612267251 * 3));
			eris.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.WATER);
			eris.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/eris.png"));
			eris.setDimensionInfo(Config.erisID, WorldProviderEris.class);
		}
		if (Config.kepler22b && Config.keplerSolarSystems) {
			kepler22b = new Planet("kepler22b").setParentSolarSystem(ExtraPlanets_SolarSystems.kepler22);
			if (Config.morePlanetsCompatibilityAdv)
				kepler22b.setTierRequired(7);
			else
				kepler22b.setTierRequired(10);
			kepler22b.setRingColorRGB(0.1F, 0.9F, 0.6F);
			kepler22b.setPhaseShift(1.45F);
			kepler22b.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F));
			kepler22b.setRelativeOrbitTime(164.84118291347207009857612267251F);
			kepler22b.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.WATER).atmosphereComponent(IAtmosphericGas.OXYGEN);
			kepler22b.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler22b.png"));
			kepler22b.setDimensionInfo(Config.kepler22bID, WorldProviderKepler22b.class);
		}
		if (Config.kuiperBelt) {
			kuiperBelt = RegisterHelper.registerUnreachablePlanet("kuiperBelt", GalacticraftCore.solarSystemSol);
			if (kuiperBelt != null)
				kuiperBelt.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(4.0F + Config.kuiperBeltDistanceOffset, 4.0F + Config.kuiperBeltDistanceOffset))
						.setRelativeOrbitTime(164.84118291347207009857612267251F);
			kuiperBelt.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kuiper_belt.png"));
		}
		if (Config.makemake) {
			makemake = RegisterHelper.registerUnreachablePlanet("makemake", GalacticraftCore.solarSystemSol);
			if (makemake != null)
				makemake.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(4.50F + Config.makemakeDistanceOffset, 4.50F + Config.makemakeDistanceOffset))
						.setRelativeOrbitTime(164.84118291347207009857612267251F);
			makemake.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/makemake.png"));
		}
		if (Config.haumea) {
			haumea = RegisterHelper.registerUnreachablePlanet("haumea", GalacticraftCore.solarSystemSol);
			if (haumea != null)
				haumea.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.50F + Config.haumeaDistanceOffset, 3.50F + Config.haumeaDistanceOffset))
						.setRelativeOrbitTime(164.84118291347207009857612267251F);
			haumea.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/haumea.png"));
		}
		if (Config.keplerSolarSystems) {
			// Kepler Solar System

			// Kepler 47 Solar System
			kepler47b = RegisterHelper.registerUnreachablePlanet("kepler47b", ExtraPlanets_SolarSystems.kepler47);
			if (kepler47b != null)
				kepler47b.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
			kepler47b.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler47b.png"));

			kepler47c = RegisterHelper.registerUnreachablePlanet("kepler47c", ExtraPlanets_SolarSystems.kepler47);
			if (kepler47c != null)
				kepler47c.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
			kepler47c.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler47c.png"));

			// Kepler 62 Solar System
			kepler62b = RegisterHelper.registerUnreachablePlanet("kepler62b", ExtraPlanets_SolarSystems.kepler62);
			if (kepler62b != null)
				kepler62b.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(0.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 6);
			kepler62b.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62b.png"));

			kepler62c = RegisterHelper.registerUnreachablePlanet("kepler62c", ExtraPlanets_SolarSystems.kepler62);
			if (kepler62c != null)
				kepler62c.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(1.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 5);
			kepler62c.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62c.png"));

			kepler62d = RegisterHelper.registerUnreachablePlanet("kepler62d", ExtraPlanets_SolarSystems.kepler62);
			if (kepler62d != null)
				kepler62d.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(2.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.50F, 1.50F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 4);
			kepler62d.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62d.png"));

			kepler62e = RegisterHelper.registerUnreachablePlanet("kepler62e", ExtraPlanets_SolarSystems.kepler62);
			if (kepler62e != null)
				kepler62e.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(3.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.75F, 1.75F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 3);
			kepler62e.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62e.png"));

			kepler62f = RegisterHelper.registerUnreachablePlanet("kepler62f", ExtraPlanets_SolarSystems.kepler62);
			if (kepler62f != null)
				kepler62f.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(4.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.0F, 2.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 2);
			kepler62f.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler62f.png"));

			// Kepler 69 Solar System
			kepler69b = RegisterHelper.registerUnreachablePlanet("kepler69b", ExtraPlanets_SolarSystems.kepler69);
			if (kepler69b != null)
				kepler69b.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(5.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(164.84118291347207009857612267251F / 1);
			kepler69b.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler69b.png"));

			kepler69c = RegisterHelper.registerUnreachablePlanet("kepler69c", ExtraPlanets_SolarSystems.kepler69);
			if (kepler69c != null)
				kepler69c.setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(6.45F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
			kepler69c.setBodyIcon(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/gui/celestialbodies/kepler69c.png"));
		}
	}

	private static void registerPlanets() {
		if (Config.mercury) {
			GalaxyRegistry.registerPlanet(mercury);
			GalacticraftRegistry.registerTeleportType(WorldProviderMercury.class, new TeleportTypeMercury());
			GalacticraftRegistry.registerRocketGui(WorldProviderMercury.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/mercury_rocket_gui.png"));
		}
		if (Config.venus) {
			GalaxyRegistry.registerPlanet(venus);
			GalacticraftRegistry.registerTeleportType(WorldProviderVenus.class, new TeleportTypeVenus());
			GalacticraftRegistry.registerRocketGui(WorldProviderVenus.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/venus_rocket_gui.png"));
		}
		if (Config.ceres) {
			GalaxyRegistry.registerPlanet(ceres);
			GalacticraftRegistry.registerTeleportType(WorldProviderCeres.class, new TeleportTypeCeres());
			GalacticraftRegistry.registerRocketGui(WorldProviderCeres.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/ceres_rocket_gui.png"));
		}
		if (Config.jupiter) {
			GalaxyRegistry.registerPlanet(jupiter);
			GalacticraftRegistry.registerTeleportType(WorldProviderJupiter.class, new TeleportTypeJupiter());
			GalacticraftRegistry.registerRocketGui(WorldProviderJupiter.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/jupiter_rocket_gui.png"));
		}
		if (Config.saturn) {
			GalaxyRegistry.registerPlanet(saturn);
			GalacticraftRegistry.registerTeleportType(WorldProviderSaturn.class, new TeleportTypeSaturn());
			GalacticraftRegistry.registerRocketGui(WorldProviderSaturn.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/saturn_rocket_gui.png"));
		}
		if (Config.uranus) {
			GalaxyRegistry.registerPlanet(uranus);
			GalacticraftRegistry.registerTeleportType(WorldProviderUranus.class, new TeleportTypeUranus());
			GalacticraftRegistry.registerRocketGui(WorldProviderUranus.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/uranus_rocket_gui.png"));
		}
		if (Config.neptune) {
			GalaxyRegistry.registerPlanet(neptune);
			GalacticraftRegistry.registerTeleportType(WorldProviderNeptune.class, new TeleportTypeNeptune());
			GalacticraftRegistry.registerRocketGui(WorldProviderNeptune.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/neptune_rocket_gui.png"));
		}
		if (Config.pluto) {
			GalaxyRegistry.registerPlanet(pluto);
			GalacticraftRegistry.registerTeleportType(WorldProviderPluto.class, new TeleportTypePluto());
			GalacticraftRegistry.registerRocketGui(WorldProviderPluto.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/pluto_rocket_gui.png"));
		}
		if (Config.eris) {
			GalaxyRegistry.registerPlanet(eris);
			GalacticraftRegistry.registerTeleportType(WorldProviderEris.class, new TeleportTypeEris());
			GalacticraftRegistry.registerRocketGui(WorldProviderEris.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/eris_rocket_gui.png"));
		}
		if (Config.kepler22b && Config.keplerSolarSystems) {
			GalaxyRegistry.registerPlanet(kepler22b);
			GalacticraftRegistry.registerTeleportType(WorldProviderKepler22b.class, new TeleportTypeKepler22b());
			GalacticraftRegistry.registerRocketGui(WorldProviderKepler22b.class, new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/kepler22b_rocket_gui.png"));
		}
	}
}
