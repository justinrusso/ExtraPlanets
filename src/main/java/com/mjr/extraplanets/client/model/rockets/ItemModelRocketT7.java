package com.mjr.extraplanets.client.model.rockets;

import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import micdoodle8.mods.galacticraft.core.wrappers.ModelTransformWrapper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraftforge.common.model.TRSRTransformation;

import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public class ItemModelRocketT7 extends ModelTransformWrapper
{
    public ItemModelRocketT7(IBakedModel modelToWrap)
    {
        super(modelToWrap);
    }

    @Override
    protected Matrix4f getTransformForPerspective(TransformType cameraTransformType)
    {
        if (cameraTransformType == TransformType.GUI)
        {
            Vector3f trans = new Vector3f(-0.12F, 0.0F, -0.12F);
            Matrix4f ret = new Matrix4f();
            ret.setIdentity();
            Matrix4f mul = new Matrix4f();
            mul.setIdentity();
            Quat4f rot = TRSRTransformation.quatFromXYZDegrees(new Vector3f(30, 225, 0));
            mul.setRotation(rot);
            ret.mul(mul);
            mul.setIdentity();
            mul.setScale(0.61F);
            ret.mul(mul);
            mul.setIdentity();
            mul.setTranslation(new Vector3f(-0.25F, -0.35F, 0.0F));
            ret.mul(mul);
            mul.setIdentity();
            mul.rotY((float) (Math.PI / 2.0F));
            ret.mul(mul);
            mul.setIdentity();
            mul.rotX((float) (Math.PI / 4.0F));
            ret.mul(mul);
            mul.setIdentity();
            mul.setTranslation(trans);
            ret.mul(mul);
            mul.setIdentity();
            mul.rotY(ClientUtil.getMilliseconds() / 1000.0F);
            ret.mul(mul);
            mul.setIdentity();
            trans.scale(-1.0F);
            mul.setTranslation(trans);
            ret.mul(mul);
            mul.setIdentity();
            mul.setScale(0.3F);
            ret.mul(mul);
            return ret;
        }

        if (cameraTransformType == TransformType.FIRST_PERSON_RIGHT_HAND)
        {
            Vector3f trans = new Vector3f(0.5F, 3.2F, -3.6F);
            Matrix4f ret = new Matrix4f();
            ret.setIdentity();
            Matrix4f mul = new Matrix4f();
            mul.setIdentity();
            Quat4f rot = TRSRTransformation.quatFromXYZDegrees(new Vector3f(0, 230, 0));
            mul.setRotation(rot);
            ret.mul(mul);
            mul.setIdentity();
            mul.setScale(0.45F);
            ret.mul(mul);
            mul.setIdentity();
            mul.rotX((float) (Math.PI / 2.0F));
            ret.mul(mul);
            mul.setIdentity();
            mul.rotZ((float) (-0.65F + Math.PI));
            ret.mul(mul);
            mul.setIdentity();
            mul.setTranslation(trans);
            ret.mul(mul);
            mul.setIdentity();
            mul.rotX((float) (Math.PI));
            ret.mul(mul);
            return ret;
        }

        if (cameraTransformType == TransformType.THIRD_PERSON_RIGHT_HAND || cameraTransformType == TransformType.THIRD_PERSON_LEFT_HAND)
        {
            Vector3f trans = new Vector3f(1.4F, -4.6F, 1.1F);
            Matrix4f ret = new Matrix4f();
            ret.setIdentity();
            Matrix4f mul = new Matrix4f();
            mul.setIdentity();
            Quat4f rot = TRSRTransformation.quatFromXYZDegrees(new Vector3f(75, 15, 0));
            mul.setRotation(rot);
            ret.mul(mul);
            mul.setIdentity();
            mul.setScale(0.6F);
            ret.mul(mul);
            mul.setIdentity();
            mul.rotX((float) (Math.PI / 3.0F));
            ret.mul(mul);
            mul.setIdentity();
            mul.rotZ((float) (-Math.PI / 2.0F));
            ret.mul(mul);
            mul.setIdentity();
            mul.rotX(0.3F);
            ret.mul(mul);
            mul.setIdentity();
            mul.setTranslation(trans);
            ret.mul(mul);
            return ret;
        }

        if (cameraTransformType == TransformType.GROUND)
        {
            Matrix4f ret = new Matrix4f();
            ret.setIdentity();
            Matrix4f mul = new Matrix4f();
            mul.setIdentity();
            mul.setScale(0.1F);
            ret.mul(mul);
            return ret;
        }

        return null;
    }
}
