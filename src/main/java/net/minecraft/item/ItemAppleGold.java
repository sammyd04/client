package net.minecraft.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ItemAppleGold extends ItemFood
{

    private IIcon cronyxe;

    public ItemAppleGold(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_)
    {
        super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
        this.setHasSubtypes(true);
    }

    public boolean hasEffect(ItemStack p_77636_1_)
    {
        return p_77636_1_.getItemDamage() > 0;
    }

    /**
     * Return an item rarity from EnumRarity
     */
    public EnumRarity getRarity(ItemStack p_77613_1_)
    {
        return p_77613_1_.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
    }

    protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_)
    {
        if (!p_77849_2_.isClient)
        {
            int damage = p_77849_1_.getItemDamage();

            p_77849_3_.addPotionEffect(new PotionEffect(damage == 2 ? Potion.field_76434_w.id : Potion.field_76444_x.id, 2400, damage == 2 ? 1 : 0));

            if (damage > 0)
            {
                p_77849_3_.addPotionEffect(new PotionEffect(Potion.regeneration.id, damage == 2 ? 160 : 600, damage == 2 ? 1 : 4));
                if (damage != 2) {
                    p_77849_3_.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
                    p_77849_3_.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
                }
            }
        }

        if (p_77849_1_.getItemDamage() == 0)
        {
            super.onFoodEaten(p_77849_1_, p_77849_2_, p_77849_3_);
        }
    }

    /**
     * This returns the sub items
     */
    public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_)
    {
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 0));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 1));
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 2));
    }

    @Override
    public void registerIcons(IIconRegister register) {
        super.registerIcons(register);

        cronyxe = register.registerIcon("apple_cronyxe");
    }

    @Override
    public IIcon getIconFromDamage(int damage) {
        return damage == 2 ? cronyxe : super.getIconFromDamage(damage);
    }
}
