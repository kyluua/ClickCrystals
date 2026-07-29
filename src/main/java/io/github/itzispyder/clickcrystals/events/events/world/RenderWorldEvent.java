package io.github.itzispyder.clickcrystals.events.events.world;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.itzispyder.clickcrystals.events.Event;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public class RenderWorldEvent extends Event {

    private final PoseStack poseStack;
    private final Camera camera;
    private final DeltaTracker deltaTracker;
    private final SubmitNodeCollector submitNodeCollector;

    public RenderWorldEvent(PoseStack poseStack, Camera camera, DeltaTracker deltaTracker, SubmitNodeCollector submitNodeCollector) {
        this.poseStack = poseStack;
        this.camera = camera;
        this.deltaTracker = deltaTracker;
        this.submitNodeCollector = submitNodeCollector;
    }

    public PoseStack getPoseStack() {
        return poseStack;
    }

    public DeltaTracker getDeltaTracker() {
        return deltaTracker;
    }

    public SubmitNodeCollector getSubmitNodeCollector() {
        return submitNodeCollector;
    }

    public Camera getCamera() {
        return camera;
    }

    public Vec3 getCameraRelativePosition(Vec3 position) {
        return position.subtract(getCamera().position());
    }

    public Vec3 getCameraRelativePosition(BlockPos blockPos) {
        Vec3 cameraPosition = getCamera().position();
        double x = blockPos.getX() - cameraPosition.x;
        double y = blockPos.getY() - cameraPosition.y;
        double z = blockPos.getZ() - cameraPosition.z;
        return new Vec3(x, y, z);
    }
}
