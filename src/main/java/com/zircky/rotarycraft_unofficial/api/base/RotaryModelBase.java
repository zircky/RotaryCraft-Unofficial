package com.zircky.rotarycraft_unofficial.api.base;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;

public abstract class RotaryModelBase {
  protected final ModelPart root;

  protected RotaryModelBase(ModelPart root) {
    this.root = root;
  }

  public ModelPart getRoot() {
    return root;
  }

  public void renderAll(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay) {
    root.render(poseStack, buffer, packedLight, packedOverlay);
  }

  protected void setVisible(ModelPart parent, String childName, boolean visible) {
    ModelPart child = parent.getChild(childName);
    if (child != null) {
      child.visible = visible;
    }
  }
}
