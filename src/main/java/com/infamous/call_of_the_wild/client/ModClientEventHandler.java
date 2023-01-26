package com.infamous.call_of_the_wild.client;

import com.infamous.call_of_the_wild.AllBarkAllBite;
import com.infamous.call_of_the_wild.client.renderer.ABABWolfRenderer;
import com.infamous.call_of_the_wild.client.renderer.DogRenderer;
import com.infamous.call_of_the_wild.client.renderer.HoundmasterRenderer;
import com.infamous.call_of_the_wild.client.renderer.IllagerHoundRenderer;
import com.infamous.call_of_the_wild.client.renderer.model.AndreDogModel;
import com.infamous.call_of_the_wild.client.renderer.model.HoundmasterModel;
import com.infamous.call_of_the_wild.client.renderer.model.IllagerHoundModelTemp;
import com.infamous.call_of_the_wild.common.registry.ABABEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = AllBarkAllBite.MODID, value = Dist.CLIENT)
public class ModClientEventHandler {

    @SubscribeEvent
    static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ABABModelLayers.DOG, AndreDogModel::createBodyLayer);
        event.registerLayerDefinition(ABABModelLayers.HOUNDMASTER, HoundmasterModel::createBodyLayer);
        event.registerLayerDefinition(ABABModelLayers.ILLAGER_HOUND, IllagerHoundModelTemp::createBodyLayer);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ABABEntityTypes.DOG.get(), DogRenderer::new);
        event.registerEntityRenderer(EntityType.WOLF, ABABWolfRenderer::new);
        event.registerEntityRenderer(ABABEntityTypes.HOUNDMASTER.get(), HoundmasterRenderer::new);
        event.registerEntityRenderer(ABABEntityTypes.ILLAGER_HOUND.get(), IllagerHoundRenderer::new);
    }

}
