package net.ympl.mineminenomiaddontemplate.abilities.test;

import net.minecraft.entity.LivingEntity;
import xyz.pixelatedw.mineminenomi.api.abilities.Ability;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCategory;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCore;
import xyz.pixelatedw.mineminenomi.api.abilities.IAbility;

public class ExampleAbility extends Ability {
    public static final AbilityCore INSTANCE = (new AbilityCore.Builder("Example Ability", AbilityCategory.DEVIL_FRUITS, ExampleAbility::new))
            .addDescriptionLine("Example Ability!", new Object[0])
            .build();

    public ExampleAbility(AbilityCore<?> core) {
        super(core);
        this.isNew = true;
        addUseEvent(this::onUseEvent);
    }

    private void onUseEvent(LivingEntity entity, IAbility ability) {
        // Do something here!

        this.cooldownComponent.startCooldown(entity, 100);
    }
}
