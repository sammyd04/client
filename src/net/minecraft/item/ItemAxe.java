package net.minecraft.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

import java.util.Set;

public class ItemAxe extends ItemTool
{
    public static final Set<Block> PROPER_BLOCKS = Sets.newHashSet(Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2,
            Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin);

    protected ItemAxe(Item.ToolMaterial p_i45327_1_)
    {
        super(3.0F, p_i45327_1_, PROPER_BLOCKS);
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return p_150893_2_.getMaterial() != Material.wood && p_150893_2_.getMaterial() != Material.plants && p_150893_2_.getMaterial() != Material.vine ? super.func_150893_a(p_150893_1_, p_150893_2_) : this.efficiencyOnProperMaterial;
    }
}
