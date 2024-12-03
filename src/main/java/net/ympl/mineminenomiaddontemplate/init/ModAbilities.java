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
        registerAbilities(new AbilityCore[]{ExampleAbility.INSTANCE});
    }

    private static <T extends AkumaNoMiItem> T registerFruit(T fruit) {
        String resourceName = WyHelper.getResourceName(fruit.getDevilFruitName());
        WyRegistry.getLangMap().put("item.mineminenomi." + resourceName, fruit.getDevilFruitName());
        WyRegistry.registerItem(fruit.getDevilFruitName(), () -> fruit);
        if (fruit.getAbilities() != null && (fruit.getAbilities()).length > 0)
            registerAbilities(fruit.getAbilities());
        return fruit;
    }

    private static void registerAbilities(AbilityCore[] abilities) {
        Arrays.stream(abilities).filter(Objects::nonNull).forEach(WyRegistry::registerAbility);
    }
}
