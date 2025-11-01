package com.zircky.rotarycraft_unofficial.client.model.engine;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.api.base.RotaryModelBase;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ModelDCEngine extends RotaryModelBase {

  public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(RotaryCraftUnofficial.MODID, "dc_electric_engine"), "main");

  private final ModelPart base;
  private final ModelPart shaft;

  public ModelDCEngine(ModelPart root) {
    super(root);
    this.base = root.getChild("base");
    this.shaft = root.getChild("shaft");
  }

  public ModelPart getBase() {
    return base;
  }

  public ModelPart getShaft() {
    return shaft;
  }

  public static LayerDefinition createBodyLayer() {
    MeshDefinition meshDefinition = new MeshDefinition();
    PartDefinition root = meshDefinition.getRoot();

    // === shaft (Rotating Shaft + Shape12, Shape13) ===
    PartDefinition shaft = root.addOrReplaceChild("shaft", CubeListBuilder.create(), PartPose.ZERO);

    // Shape12
    shaft.addOrReplaceChild("shape12",
        CubeListBuilder.create()
            .texOffs(0, 58)
            .addBox(7.0F - 8.0F, 8.0F - 8.0F, -0.5F - 8.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0, 0, 0));

    // Shape13 (same cube, but rotated 45° around Z)
    shaft.addOrReplaceChild("shape13",
        CubeListBuilder.create()
            .texOffs(0, 58)
            .addBox(7.0F - 8.0F, 8.0F - 8.0F, -0.5F - 8.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)),
        PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, (float) Math.toRadians(45)));

    // === base (Rest of the case) ===
    PartDefinition base = root.addOrReplaceChild("base", CubeListBuilder.create(), PartPose.ZERO);

    // Shape14 — Rear Box
    base.addOrReplaceChild("shape14",
        CubeListBuilder.create()
            .texOffs(72, 16)
            .addBox(2.0F - 8.0F, 1.0F - 8.0F, 5.0F - 8.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)),
        PartPose.ZERO);

    // Shape2 — Top Cover
    base.addOrReplaceChild("shape2",
        CubeListBuilder.create()
            .texOffs(16, 48)
            .addBox(4.0F - 8.0F, 11.0F - 8.0F, 5.0F - 8.0F, 8.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
        PartPose.ZERO);

    // Shape3
    base.addOrReplaceChild("shape3",
        CubeListBuilder.create()
            .texOffs(0, 32)
            .addBox(3.0F - 8.0F, 1.0F - 8.0F, 4.0F - 8.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)),
        PartPose.ZERO);

    // Shape4
    base.addOrReplaceChild("shape4",
        CubeListBuilder.create()
            .texOffs(4, 32)
            .addBox(12.0F - 8.0F, 1.0F - 8.0F, 4.0F - 8.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)),
        PartPose.ZERO);

    // Shape5
    base.addOrReplaceChild("shape5",
        CubeListBuilder.create()
            .texOffs(8, 32)
            .addBox(11.0F - 8.0F, 10.0F - 8.0F, 4.0F - 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
        PartPose.ZERO);

    // Shape6
    base.addOrReplaceChild("shape6",
        CubeListBuilder.create()
            .texOffs(12, 32)
            .addBox(4.0F - 8.0F, 10.0F - 8.0F, 4.0F - 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
        PartPose.ZERO);

    // Shape7
    base.addOrReplaceChild("shape7",
        CubeListBuilder.create()
            .texOffs(16, 32)
            .addBox(5.0F - 8.0F, 11.0F - 8.0F, 4.0F - 8.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
        PartPose.ZERO);

    // Shape8 — Top Plate
    base.addOrReplaceChild("shape8",
        CubeListBuilder.create()
            .texOffs(32, 32)
            .addBox(3.0F - 8.0F, 11.0F - 8.0F, 6.0F - 8.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
        PartPose.ZERO);

    // Shape1 — foundation
    base.addOrReplaceChild("shape1",
        CubeListBuilder.create()
            .texOffs(0, 0)
            .addBox(0.0F - 8.0F, 0.0F - 8.0F, 0.0F - 8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)),
        PartPose.ZERO);

    return LayerDefinition.create(meshDefinition, 128, 128);

  }


}
