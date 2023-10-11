// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public class hard_hat extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer left_r1;

	public hard_hat() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(7, 7).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(1, 1).addBox(-5.0F, -8.0F, -5.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		Head.setTextureOffset(5, 3).addBox(-4.0F, -5.0F, -8.0F, 8.0F, 0.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(4, 8).addBox(-0.5F, -9.5F, -3.0F, 1.0F, 0.5F, 7.0F, 0.0F, false);

		left_r1 = new ModelRenderer(this);
		left_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(left_r1);
		setRotationAngle(left_r1, 0.0F, 3.1416F, 0.0F);
		left_r1.setTextureOffset(1, 1).addBox(-5.0F, -8.0F, -5.0F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		left_r1.setTextureOffset(7, 7).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}