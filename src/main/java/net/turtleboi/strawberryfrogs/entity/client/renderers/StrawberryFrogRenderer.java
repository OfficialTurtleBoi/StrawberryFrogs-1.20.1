package net.turtleboi.strawberryfrogs.entity.client.renderers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.FrogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.monster.Zombie;
import net.turtleboi.strawberryfrogs.StrawberryFrogs;

public class StrawberryFrogRenderer extends FrogRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(StrawberryFrogs.MOD_ID, "textures/entity/strawberry_frog.png");
    public StrawberryFrogRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Frog pEntity) {
        return TEXTURE;
    }
}
