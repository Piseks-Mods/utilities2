
package cz.pisekpiskovec.piseksutilities.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import cz.pisekpiskovec.piseksutilities.entity.BeanyEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class BeanyRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(BeanyEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Beany(), 0.2f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("piseks_utilities_ii:textures/entities/beany.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.9.4
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Beany extends EntityModel<Entity> {
		private final ModelRenderer bottom;
		private final ModelRenderer legs;
		private final ModelRenderer right_leg_bone;
		private final ModelRenderer left_leg_bone;
		private final ModelRenderer body;
		private final ModelRenderer arms;
		private final ModelRenderer right_arm_bone;
		private final ModelRenderer right_arm_r1;
		private final ModelRenderer left_arm_bone;
		private final ModelRenderer left_arm_r1;
		private final ModelRenderer head;

		public Beany() {
			textureWidth = 32;
			textureHeight = 32;
			bottom = new ModelRenderer(this);
			bottom.setRotationPoint(0.0F, 24.0F, 0.0F);
			bottom.setTextureOffset(17, 11).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			bottom.setTextureOffset(13, 13).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			legs = new ModelRenderer(this);
			legs.setRotationPoint(0.0F, 0.0F, 0.0F);
			bottom.addChild(legs);
			right_leg_bone = new ModelRenderer(this);
			right_leg_bone.setRotationPoint(-1.0F, -2.0F, -0.5F);
			legs.addChild(right_leg_bone);
			right_leg_bone.setTextureOffset(14, 15).addBox(-1.75F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			left_leg_bone = new ModelRenderer(this);
			left_leg_bone.setRotationPoint(1.0F, -2.0F, -0.5F);
			legs.addChild(left_leg_bone);
			left_leg_bone.setTextureOffset(6, 14).addBox(-0.25F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(0, 6).addBox(-4.0F, -13.0F, -1.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(-5.0F, -11.0F, -1.0F, 10.0F, 5.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(0, 9).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
			arms = new ModelRenderer(this);
			arms.setRotationPoint(0.0F, -7.5F, 0.0F);
			body.addChild(arms);
			right_arm_bone = new ModelRenderer(this);
			right_arm_bone.setRotationPoint(-5.1F, -0.6852F, -0.5695F);
			arms.addChild(right_arm_bone);
			right_arm_r1 = new ModelRenderer(this);
			right_arm_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			right_arm_bone.addChild(right_arm_r1);
			setRotationAngle(right_arm_r1, 0.8727F, 0.0F, 0.0F);
			right_arm_r1.setTextureOffset(0, 11).addBox(0.0F, -0.5F, -3.75F, 0.0F, 1.0F, 4.0F, 0.0F, false);
			left_arm_bone = new ModelRenderer(this);
			left_arm_bone.setRotationPoint(5.1F, -0.6852F, -0.5695F);
			arms.addChild(left_arm_bone);
			left_arm_r1 = new ModelRenderer(this);
			left_arm_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			left_arm_bone.addChild(left_arm_r1);
			setRotationAngle(left_arm_r1, 0.8727F, 0.0F, 0.0F);
			left_arm_r1.setTextureOffset(0, 10).addBox(0.0F, -0.5F, -3.75F, 0.0F, 1.0F, 4.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 10.0F, -0.5F);
			head.setTextureOffset(0, 12).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			head.setTextureOffset(17, 8).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bottom.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.left_leg_bone.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.left_arm_bone.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.right_leg_bone.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_arm_bone.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}

}
