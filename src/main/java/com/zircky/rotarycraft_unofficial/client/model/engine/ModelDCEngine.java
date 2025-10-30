package com.zircky.rotarycraft_unofficial.client.model.engine;

import com.zircky.rotarycraft_unofficial.RotaryCraftUnofficial;
import com.zircky.rotarycraft_unofficial.api.base.RotaryModelBase;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ModelDCEngine extends RotaryModelBase {

  public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(RotaryCraftUnofficial.id("dc_electric_engine"), "main");

  private final ModelPart base;
  private final ModelPart housing;
  private final ModelPart rotor;
  private final ModelPart shaft;

  public ModelDCEngine(ModelPart root) {
    super(root);
    this.base = root.getChild("base");
    this.housing = root.getChild("housing");
    this.rotor = root.getChild("rotor");
    this.shaft = root.getChild("shaft");
  }

  public ModelPart getBase() {
    return base;
  }

  public ModelPart getHousing() {
    return housing;
  }

  public ModelPart getRotor() {
    return rotor;
  }

  public ModelPart getShaft() {
    return shaft;
  }

  public static LayerDefinition createBodyLayer() {
    MeshDefinition meshDefinition = new MeshDefinition();
    PartDefinition root = meshDefinition.getRoot();

    PartDefinition base = root.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16, 2, 16, new CubeDeformation(0.0f)), PartPose.ZERO);

    PartDefinition housing = root.addOrReplaceChild("housing", CubeListBuilder.create().texOffs(0, 18).addBox(-6.F, -8.0F, -6.0F, 12, 10, 12, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

    PartDefinition shaft = root.addOrReplaceChild("shaft", CubeListBuilder.create().texOffs(48, 18).addBox(-1.0F, -1.0F, -10.0F, 2, 2, 20, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

    PartDefinition rotor = root.addOrReplaceChild("rotor", CubeListBuilder.create().texOffs(0, 40).addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, new CubeDeformation(0.0F)).texOffs(24, 40).addBox(-8.0F, -1.0F, -2.0F, 16, 2, 4, new CubeDeformation(0.0F)).texOffs(24, 46).addBox(-2.0F, -1.0F, -8.0F, 4, 2, 16, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

    return LayerDefinition.create(meshDefinition, 128, 128);

  }


}
