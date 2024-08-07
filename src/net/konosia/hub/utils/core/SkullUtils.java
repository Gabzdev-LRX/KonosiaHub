package net.konosia.hub.utils.core;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullUtils {
    public static ItemStack getSkullByURL(String url) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if (url.isEmpty()) {
            return head;
        } else {
            SkullMeta headMeta = (SkullMeta)head.getItemMeta();
            GameProfile profile = new GameProfile(UUID.randomUUID(), (String)null);
            byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
            profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
            Field profileField = null;

            try {
                profileField = headMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(headMeta, profile);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException var7) {
                var7.printStackTrace();
            }

            head.setItemMeta(headMeta);
            return head;
        }
    }

    public static ItemStack getSkullByURL(String url, String displayName) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if (url.isEmpty()) {
            return head;
        } else {
            SkullMeta headMeta = (SkullMeta)head.getItemMeta();
            headMeta.setDisplayName(displayName);
            GameProfile profile = new GameProfile(UUID.randomUUID(), (String)null);
            byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
            profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
            Field profileField = null;

            try {
                profileField = headMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(headMeta, profile);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException var8) {
                var8.printStackTrace();
            }

            head.setItemMeta(headMeta);
            return head;
        }
    }

    public static ItemStack getSkullByURL(String url, String displayName, String... lores) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if (url.isEmpty()) {
            return head;
        } else {
            List<String> lore = new ArrayList(Arrays.asList(lores));
            SkullMeta headMeta = (SkullMeta)head.getItemMeta();
            headMeta.setDisplayName(displayName);
            headMeta.setLore(lore);
            GameProfile profile = new GameProfile(UUID.randomUUID(), (String)null);
            byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
            profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
            Field profileField = null;

            try {
                profileField = headMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(headMeta, profile);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException var10) {
                var10.printStackTrace();
            }

            head.setItemMeta(headMeta);
            return head;
        }
    }

    public static ItemStack getSkullByURL(String url, String displayName, String lores) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if (url.isEmpty()) {
            return head;
        } else {
            List<String> lore = new ArrayList();
            lore.add(lores);
            SkullMeta headMeta = (SkullMeta)head.getItemMeta();
            headMeta.setDisplayName(displayName);
            headMeta.setLore(lore);
            GameProfile profile = new GameProfile(UUID.randomUUID(), (String)null);
            byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
            profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
            Field profileField = null;

            try {
                profileField = headMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(headMeta, profile);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException var10) {
                var10.printStackTrace();
            }

            head.setItemMeta(headMeta);
            return head;
        }
    }
}
