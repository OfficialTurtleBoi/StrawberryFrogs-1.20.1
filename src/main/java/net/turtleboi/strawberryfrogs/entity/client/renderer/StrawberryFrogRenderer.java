package net.turtleboi.strawberryfrogs.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.FrogRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.frog.Frog;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;
import net.turtleboi.strawberryfrogs.entity.StrawberryFrogEntity;

public class StrawberryFrogRenderer extends FrogRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(StrawberryFrogs.MOD_ID, "textures/entity/strawberry_frog.png");
    public StrawberryFrogRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Frog pEntity) {
        return TEXTURE;
    }

    @Override
    protected void scale(Frog pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        if (pLivingEntity instanceof StrawberryFrogEntity strawberryFrog) {
            float scaleFactor = 1.0F + (strawberryFrog.getStrawberriesEaten() * 0.25F);
            pPoseStack.scale(scaleFactor, scaleFactor, scaleFactor);
        }
    }
}
