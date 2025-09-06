package net.mcreator.showbiz.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.showbiz.network.ShowbizModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CooldowncalculatorProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ShowbizModVariables.PLAYER_VARIABLES).playerdonateuses == 10) {
			if (!(entity.getData(ShowbizModVariables.PLAYER_VARIABLES).playerdonatecooldown == 36000)) {
				{
					ShowbizModVariables.PlayerVariables _vars = entity.getData(ShowbizModVariables.PLAYER_VARIABLES);
					_vars.playerdonatecooldown = entity.getData(ShowbizModVariables.PLAYER_VARIABLES).playerdonatecooldown + 1;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					ShowbizModVariables.PlayerVariables _vars = entity.getData(ShowbizModVariables.PLAYER_VARIABLES);
					_vars.playerdonateuses = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					ShowbizModVariables.PlayerVariables _vars = entity.getData(ShowbizModVariables.PLAYER_VARIABLES);
					_vars.playerdonatecooldown = 0;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}