package me.coley.recaf.decompile.vineflower;

import me.coley.recaf.util.Log;
import org.jetbrains.java.decompiler.main.extern.IFernflowerLogger;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import java.util.logging.Level;
import java.util.logging.LogManager;

/**
 * Logger for Vineflower
 *
 * @author therathatter
 */
public class VineflowerLogger extends IFernflowerLogger {
	private static final String VF_PREFIX = "VF: ";

	@Override
	public void writeMessage(String message, Severity severity) {
		switch (severity) {
			case TRACE: {
				Log.trace(message);
				break;
			}
			case INFO: {
				Log.info(message);
				break;
			}
			case WARN: {
				Log.warn(message);
				break;
			}
			case ERROR: {
				Log.error(VF_PREFIX + message);
			}
		}
	}

	@Override
	public void writeMessage(String message, Severity severity, Throwable throwable) {
		Log.error(VF_PREFIX + message, throwable);
	}
}