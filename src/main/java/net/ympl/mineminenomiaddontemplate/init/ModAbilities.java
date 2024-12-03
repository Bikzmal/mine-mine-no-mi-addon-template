package net.ympl.mineminenomiaddontemplate.init;

import net.ympl.mineminenomiaddontemplate.abilities.test.ExampleAbility;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCore;
import xyz.pixelatedw.mineminenomi.items.AkumaNoMiItem;
import xyz.pixelatedw.mineminenomi.wypi.WyHelper;
import xyz.pixelatedw.mineminenomi.wypi.WyRegistry;

import java.util.Arrays;
import java.util.Objects;

public class ModAbilities {
    public static void register() {
        addonRegisterAbilities(new AbilityCore[]{ExampleAbility.INSTANCE});
    }

    private static <T extends AkumaNoMiItem> T addonRegisterFruit(T fruit) {
        String resourceName = WyHelper.getResourceName(fruit.getDevilFruitName());
        WyRegistry.getLangMap().put("item.mineminenomi." + resourceName, fruit.getDevilFruitName());
        WyRegistry.registerItem(fruit.getDevilFruitName(), () -> fruit);
        if (fruit.getAbilities() != null && (fruit.getAbilities()).length > 0)
            addonRegisterAbilities(fruit.getAbilities());
        return fruit;
    }

    private static void addonRegisterAbilities(AbilityCore[] abilities) {
        Arrays.<AbilityCore>stream(abilities).filter(Objects::nonNull).forEach(abl -> WyRegistry.registerAbility(abl));
    }
}
