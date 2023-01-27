package fr.felixviart.thequakeisalie;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
                    global.projectile_damage=Integer.parseInt(args[1]);
                    Bukkit.broadcastMessage(ChatColor.GREEN+"Les dégats du projectiles sont maintenant: "+global.projectile_damage+" dmg");
                } else {
                    Bukkit.broadcastMessage(ChatColor.RED+"Argument non valide, veuillez entrer un nombre au-dessus de 0.");
                }
                break;
            case "rayon":
                if(args[1].matches("\\d+") && Float.parseFloat(args[1])!=0) {
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
                if(Material.matchMaterial(args[1])!=null) {
                    for (Material mat_val:global.possible_projectiles) {
                        if(Objects.equals(mat_val.toString(),args[1].toUpperCase())) {
                            isMatOk=true;
                            global.current_projecile=Material.valueOf(args[1].toUpperCase());
                            Bukkit.broadcastMessage(ChatColor.GREEN+"Projectile changé en "+global.current_projecile);
                        }
                    }

                    if(!isMatOk) {
                        Bukkit.broadcastMessage(ChatColor.RED+"Le projectile entré n'est pas dans la liste des projectiles disponibles (ARROW,EGG,SNOWBALL,ENDER_PEARL,ENDER_EYE).");
                    }
                } else {
                    Bukkit.broadcastMessage(ChatColor.RED+"Le projectile entré n'a pas été trouvé, veuillez réessayer.");
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
