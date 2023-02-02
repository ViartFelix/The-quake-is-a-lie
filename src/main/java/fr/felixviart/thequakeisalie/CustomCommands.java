package fr.felixviart.thequakeisalie;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import java.lang.reflect.Array;
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
                    global.projectile_rayon=Math.round(Integer.parseInt(args[1])*10f)/10f;
                    //1 unité multiply(vecteur) ~33 blocks (1/4 de cercle)
                    Bukkit.broadcastMessage(ChatColor.GREEN+"Le rayon du cercle est maintenant de : "+global.projectile_rayon+" unités, soit ~"+global.projectile_rayon*33+" blocks (1/4 de cercle)");
                } else {
                    Bukkit.broadcastMessage(ChatColor.RED+"Argument non valide, veuillez entrer un nombre au-dessus de 0. Astuce: les nombre type 'Float' on pour virgule le caractère '.'");
                }
                break;
            case "proj":
            case "projectile":
                Boolean isMatOk=true;
                    String target_proj=args[1].toUpperCase().toLowerCase();
                        switch (target_proj) {
                            case "arrow":
                                global.current_projectile=Arrow.class; //
                                break;
                            case "snowball":
                                global.current_projectile=Snowball.class; //
                                break;
                            case "egg":
                                global.current_projectile=Egg.class; //
                                break;
                            case "ender_pearl":
                                global.current_projectile=EnderPearl.class; //
                                break;
                            case "shulkerbullet":
                                global.current_projectile=ShulkerBullet.class; //
                                break;
                            case "spectralarrow":
                                global.current_projectile=SpectralArrow.class;
                                break;
                            case "expbottle":
                                global.current_projectile=ThrownExpBottle.class;
                                break;
                            case "potion":
                                global.current_projectile=ThrownPotion.class;
                                break;
                            case "trident":
                                global.current_projectile=Trident.class; //
                                break;
                            default:
                                Bukkit.broadcastMessage(ChatColor.RED+"Projectile non trouvé");
                                isMatOk = false;
                                break;
                        }
                if(!isMatOk) {
                    Bukkit.broadcastMessage(ChatColor.RED+"Le projectile entré n'est pas dans la liste des projectiles disponibles.");
                } else {
                    Bukkit.broadcastMessage(ChatColor.GREEN+"Le projectile a été changé en "+global.current_projectile+".");
                }
                break;
            case "traj":
            case "trajectoire":
                String[] convertis_array=args[1].replaceAll("\\[", "").replaceAll("]", "").split(",");

                if(convertis_array.length!=3) {
                    Bukkit.broadcastMessage(ChatColor.RED+"Veuillez mettre 3 arguments pour le décalage, "+convertis_array.length+" trouvés");
                } else {
                    global.deca_X=Double.valueOf(convertis_array[0]);
                    global.deca_Y=Double.valueOf(convertis_array[1]);
                    global.deca_Z=Double.valueOf(convertis_array[2]);
                    Bukkit.broadcastMessage(ChatColor.GREEN+"Le décalage du projectile est désormais de: X: "+global.deca_X+", Y: "+global.deca_Y+", Z; "+global.deca_Z);
                }
                break;
            default:
                Bukkit.broadcastMessage(ChatColor.RED+"Argument non valide. Les arguments valables sont 'degats','rayon','projectile' et 'trajectoire'.");
        }
        return true;
    }
}
