package ru.tenant.pass24.Helpers.WelcomeView.animation;

import androidx.annotation.NonNull;

import ru.tenant.pass24.Helpers.WelcomeView.animation.controller.AnimationController;
import ru.tenant.pass24.Helpers.WelcomeView.animation.controller.ValueController;
import ru.tenant.pass24.Helpers.WelcomeView.draw.data.Indicator;

public class AnimationManager {

    private AnimationController animationController;

    public AnimationManager(@NonNull Indicator indicator, @NonNull ValueController.UpdateListener listener) {
        this.animationController = new AnimationController(indicator, listener);
    }

    public void basic() {
        if (animationController != null) {
            animationController.end();
            animationController.basic();
        }
    }

    public void interactive(float progress) {
        if (animationController != null) {
            animationController.interactive(progress);
        }
    }

    public void end() {
        if (animationController != null) {
            animationController.end();
        }
    }
}