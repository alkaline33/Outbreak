// package com.rs.game.player.controlers.instances;
//
// import java.util.List;
//
//
// import java.util.concurrent.TimeUnit;
//
// import com.rs.cores.CoresManager;
// import com.rs.game.World;
// import com.rs.game.WorldTile;
// import com.rs.game.npc.NPC;
// import com.rs.game.player.Player;
// import com.rs.game.player.content.instances.KingBlackDragon;
// import com.rs.game.player.controlers.Controler;
// import com.rs.utils.Logger;
//
//
//
//
/// **
// *
// * @author Mr_Joopz
// *
// */
//
// public class KingBlackDragonC extends Controler {
//
// @Override
// public void start() {
// setArguments(new Object[] { 0, 0, 0, 0, 0, 0 });
// sendInterfaces();
// player.instanceminutes = 0;
// player.instanceseconds = 0;
// player.instancekilltime = 0;
// player.npcspawninstanceseconds = 0;
// }
//
// @Override
// public boolean logout() {
// KingBlackDragon.leaveInstance(player);
// remove();
// removeControler();
// return false; // so doesnt remove script
// }
//
// public static void addNpcToInstance(final Player player, final
// KingBlackDragon kingblackdragon, final NPC npc) {
// CoresManager.slowExecutor.scheduleWithFixedDelay(new Runnable() {
//
// @Override
// public void run() {
// try {
// if (kingblackdragon.endtime == true) {
// player.instancerespawnseconds = 0;
// player.instanceminutes = 0;
// player.instanceseconds = 0;
// player.npcspawninstanceseconds = 0;
// player.instancenoone = false;
// player.instanceclanonly = false;
// kingblackdragon.endtime = false;
// player.allowedinstance = false;
// player.sendMessage("Your instance has ended!");
// return;
// }
// List<Integer> npcs = World.getRegion(player.getRegionId()).getNPCsIndexes();
// if(npcs == null || npcs.isEmpty()) {
// if (player.npcspawned == true) {
// player.sendMessage("<col=ff0000>Your last kill took
// "+player.instancekilltime+" seconds.");
// // player.getPackets().sendIComponentText(57, 1, "<col=ff0000>Your last kill
// took "+player.instancekilltime+" seconds.");
// player.npcspawninstanceseconds = 0;
// }
// player.npcspawned = false;
// }
// if (player.instanceminutes >= 60) {
// KingBlackDragon.leaveInstance(player);
//
// }
// player.instanceseconds ++;
// player.npcspawninstanceseconds ++;
// //player.sendMessage(""+player.instancerespawnseconds+",
// "+player.npcspawninstanceseconds+", "+player.instanceseconds+"");
// player.instancekilltime ++;
// if (player.instanceseconds >= 60) {
// player.instanceseconds -= 60;
// player.instanceminutes += 1;
// }
// if (player.instancerespawnseconds == player.npcspawninstanceseconds &&
// player.npcspawned == false) {
// World.spawnNPC(50, new WorldTile(KingBlackDragon.getBaseX() + 33,
// KingBlackDragon.getBaseY() + 31, 0),-1, true,
// true);
// player.npcspawned = true;
// player.instancekilltime = 0;
// }
// } catch (Throwable e) {
// Logger.handle(e);
// }
//
// }
// }, 1, 1, TimeUnit.SECONDS);
// }
//
// @Override
// public boolean sendDeath() {
// remove();
// removeControler();
// removeAssets();
// KingBlackDragon.leaveInstance(player);
// return true;
// }
//
// @Override
// public void magicTeleported(int type) {
// remove();
// removeControler();
// removeAssets();
// KingBlackDragon.leaveInstance(player);
// }
//
// @Override
// public void forceClose() {
// remove();
// removeControler();
// removeAssets();
// KingBlackDragon.leaveInstance(player);
// }
//
// public void removeAssets() {
// player.instancerespawnseconds = 0;
// player.instanceminutes = 0;
// player.instanceseconds = 0;
// player.npcspawninstanceseconds = 0;
// player.instancenoone = false;
// player.instanceclanonly = false;
// KingBlackDragon.endtime = false;
// player.allowedinstance = false;
// }
//
// public void remove() {
// player.getPackets().closeInterface(
// player.getInterfaceManager().hasRezizableScreen() ? 34 : 8);
// }
//
// }
