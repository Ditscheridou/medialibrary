package de.jds;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.sun.jna.NativeLibrary;
import de.jds.controller.HomeController;
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.support.Info;

import javax.swing.*;

public class Main {

	/**
	 * Change this to point to your own vlc installation, or comment out the code if you want to use
	 * your system default installation.
	 * <p>
	 * This is a bit more explicit than using the -Djna.library.path= system property.
	 */
	private static final String NATIVE_LIBRARY_SEARCH_PATH = null;

	/**
	 * Set to true to dump out native JNA memory structures.
	 */
	private static final String DUMP_NATIVE_MEMORY = "false";


	public static void main(String[] args) {
		FlatDarculaLaf.setup();
		Info info = Info.getInstance();

		System.out.printf("vlcj             : %s%n", info.vlcjVersion() != null ? info.vlcjVersion() : "<version not available>");
		System.out.printf("os               : %s%n", val(info.os()));
		System.out.printf("java             : %s%n", val(info.javaVersion()));
		System.out.printf("java.home        : %s%n", val(info.javaHome()));
		System.out.printf("jna.library.path : %s%n", val(info.jnaLibraryPath()));
		System.out.printf("java.library.path: %s%n", val(info.javaLibraryPath()));
		System.out.printf("PATH             : %s%n", val(info.path()));
		System.out.printf("VLC_PLUGIN_PATH  : %s%n", val(info.pluginPath()));

		if (RuntimeUtil.isNix()) {
			System.out.printf("LD_LIBRARY_PATH  : %s%n", val(info.ldLibraryPath()));
		} else if (RuntimeUtil.isMac()) {
			System.out.printf("DYLD_LIBRARY_PATH          : %s%n", val(info.dyldLibraryPath()));
			System.out.printf("DYLD_FALLBACK_LIBRARY_PATH : %s%n", val(info.dyldFallbackLibraryPath()));
		}

		if (null != NATIVE_LIBRARY_SEARCH_PATH) {
			NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), NATIVE_LIBRARY_SEARCH_PATH);
		}

		System.setProperty("jna.dump_memory", DUMP_NATIVE_MEMORY);
		SwingUtilities.invokeLater(HomeController::new);
	}

	private static String val(String val) {
		return val != null ? val : "<not set>";
	}
}
