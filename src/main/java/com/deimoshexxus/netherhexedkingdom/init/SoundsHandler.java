package com.deimoshexxus.netherhexedkingdom.init;

import com.deimoshexxus.netherhexedkingdom.NetherHexedKingdomMain;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundsHandler 
{
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = 
			DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NetherHexedKingdomMain.MOD_ID);
	
	public static final RegistryObject<SoundEvent> ENTITY_HEXAN_GUARD_AMBIENT = 
			registerSoundEvent("netherhexedkingdom.entity.hexan_guard_ambient");
	
	public static final RegistryObject<SoundEvent> ENTITY_HEXAN_GUARD_HURT = 
			registerSoundEvent("netherhexedkingdom.entity.hexan_guard_hurt");
	
	public static final RegistryObject<SoundEvent> ENTITY_HEXAN_GUARD_DEATH = 
			registerSoundEvent("netherhexedkingdom.entity.hexan_guard_death");
	
	private static RegistryObject<SoundEvent> registerSoundEvent(String name)
	{
		return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(NetherHexedKingdomMain.MOD_ID, name)));
	}
}
