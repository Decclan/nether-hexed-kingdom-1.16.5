package com.deimoshexxus.netherhexedkingdom.item.render;

import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;

public class ShieldRenderInfo {

	  protected final ResourceLocation textureNoPattern;
	  
	  protected final RenderMaterial materialNoPattern;
	  
	  public ShieldRenderInfo(ResourceLocation texNoPattern, ResourceLocation texPattern) {
	    this.textureNoPattern = texNoPattern;

	    this.materialNoPattern = new RenderMaterial(this.textureNoPattern, texNoPattern);
	  }
	  
	  public RenderMaterial getMaterialNoPattern() {
	    return this.materialNoPattern;
	  }
	}