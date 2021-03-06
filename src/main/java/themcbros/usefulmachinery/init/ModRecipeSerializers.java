package themcbros.usefulmachinery.init;

import com.google.common.collect.Lists;
import net.minecraft.item.crafting.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import themcbros.usefulmachinery.UsefulMachinery;
import themcbros.usefulmachinery.client.gui.ElectricSmelterScreen;
import themcbros.usefulmachinery.recipes.CompactingRecipe;
import themcbros.usefulmachinery.recipes.CrusherRecipe;
import themcbros.usefulmachinery.recipes.ElectricSmeltingRecipe;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = UsefulMachinery.MOD_ID)
public class ModRecipeSerializers {

    private static final List<IRecipeSerializer<?>> RECIPE_SERIALIZERS = Lists.newArrayList();

    public static final CrusherRecipe.Serializer CRUSHING = register("crushing", new CrusherRecipe.Serializer());
    public static final CookingRecipeSerializer<ElectricSmeltingRecipe> ELECTRIC_SMELTING = null; // register("electric_smelting", new CookingRecipeSerializer<>(ElectricSmeltingRecipe::new, 100));
    public static final CompactingRecipe.Serializer COMPACTING = register("compacting", new CompactingRecipe.Serializer());

    private static <T extends IRecipeSerializer<? extends IRecipe<?>>> T register(String registryName, T serializer) {
        serializer.setRegistryName(UsefulMachinery.getId(registryName));
        RECIPE_SERIALIZERS.add(serializer);
        return serializer;
    }

    @SubscribeEvent
    public static void onBlockRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
        RECIPE_SERIALIZERS.forEach(event.getRegistry()::register);
    }

}
