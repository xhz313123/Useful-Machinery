package themcbros.usefulmachinery.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import themcbros.usefulmachinery.init.ModStats;
import themcbros.usefulmachinery.tileentity.CompactorTileEntity;

import javax.annotation.Nullable;

public class CompactorBlock extends MachineBlock {

    public CompactorBlock(Properties properties) {
        super(properties, ModStats.INTERACT_WITH_COMPACTOR);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CompactorTileEntity();
    }

}
