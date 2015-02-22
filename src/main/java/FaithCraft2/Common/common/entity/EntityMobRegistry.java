package FaithCraft2.Common.common.entity;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import FaithCraft2.Common.common.FaithCraft2;

public class EntityMobRegistry {
	public static void mainRegistry(){
		registerEntity();
	}

	private static void registerEntity() {
		//createEntity(Jesus.class, "Jesus", 0xD1CE1B, 0x4A3503);
		//createEntity(Angel.class, "Angel", 0xD1CE1B, 0xffffff);
		createEntity(Demon.class, "Demon", 0x480000, 0x000000);
		createEntity(DemonicCreeper.class, "DemonicCreeper", 0x800000, 0x000000);
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