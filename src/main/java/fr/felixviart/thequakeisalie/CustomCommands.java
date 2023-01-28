package fr.felixviart.thequakeisalie;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Objects;

public class CustomCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        switch (args[0]) {
            case "damage":
            case "dmg":
            case "degats":
                //Si l'argument de dégats est un nombre (merci regex)
                if(args[1].matches("\\d+") && Integer.parseInt(args[1])!=0) {
                    global.projectile_damage=(double)Integer.parseInt(args[1]);
                    Bukkit.broadcastMessage(ChatColor.GREEN+"Le projectile fait désormais: "+global.projectile_damage+" dégats");
                } else {
                    Bukkit.broadcastMessage(ChatColor.RED+"Argument non valide, veuillez entrer un nombre au-dessus de 0.");
                }
                break;
            case "rayon":
                if(args[1].matches("^(\\d*\\.?\\d*)$") && Float.parseFloat(args[1])!=0) {
                    global.projectile_rayon=Math.round(Float.parseFloat(args[1])*100f)/100f;
                    //1 unité multiply(vecteur) ~33 blocks (1/4 de cercle)
                    Bukkit.broadcastMessage(ChatColor.GREEN+"Le rayon du cercle est maintenant de : "+global.projectile_rayon+" unités, soit ~"+global.projectile_rayon*33+" blocks (1/4 de cercle)");
                } else {
                    Bukkit.broadcastMessage(ChatColor.RED+"Argument non valide, veuillez entrer un nombre au-dessus de 0. Astuce: les nombre type 'Float' on pour virgule le caractère '.'");
                }
                break;
            case "proj":
            case "projectile":
                Boolean isMatOk=false;
                for (String mat_val:global.possible_projectiles) {
                    String target_proj=args[1].toUpperCase().toLowerCase();

                    if (mat_val.toLowerCase().equals(target_proj)) {
                        switch (target_proj) {
                            case "arrow":
                                global.current_projectile=Arrow.class;
                                break;
                            case "snowball":
                                global.current_projectile=Snowball.class;
                                break;
                            case "egg":
                                global.current_projectile=Egg.class;
                                break;
                            case "ender_pearl":
                                global.current_projectile=EnderPearl.class;
                                break;
                            case "fireball":
                                global.current_projectile=Fireball.class;
                                break;
                            default:
                                Bukkit.broadcastMessage(ChatColor.RED+"Projectile non trouvé");
                                break;
                        }
                        isMatOk = true;
                    }
                }
                if(!isMatOk) {
                    Bukkit.broadcastMessage(ChatColor.RED+"Le projectile entré n'est pas dans la liste des projectiles disponibles (ARROW,EGG,SNOWBALL,ENDER_PEARL,FIREBALL).");
                }
                break;
            case "traj":
            case "trajectoire":

                break;
            default:
                Bukkit.broadcastMessage(ChatColor.RED+"Argument non valide. Les arguments valables sont 'degats','rayon','projectile' et 'trajectoire'.");
        }
        return true;
    }
}
