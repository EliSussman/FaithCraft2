package FaithCraft2.Common.common.entity;

import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.registry.EntityRegistry;
import FaithCraft2.Common.common.FaithCraft2;

public class EntityMobRegistry {
	public static void mainRegistry(){
		registerEntity();
	}

	private static void registerEntity() {
		createEntity(Jesus.class, "Jesus", 0xD1CE1B, 0x4A3503);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solid, int spots){
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
		EntityRegistry.registerModEntity(entityClass, entityName, randomID, FaithCraft2.instance, 64, 1, true);
		createEgg(randomID, solid, spots);
	}

	private static void createEgg(int randomID, int solid, int spots) {
		EntityList.entityEggs.put(Integer.valueOf(randomID), new EntityList.EntityEggInfo(randomID, solid, spots));
	}
}
