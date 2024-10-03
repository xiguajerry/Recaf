package me.coley.recaf.config;

import me.coley.recaf.decompile.DecompileImpl;

/**
 * Decompile configuration.
 *
 * @author Matt
 */
public class ConfDecompile extends Config {
	/**
	 * Decompiler to use.
	 */
	@Conf("decompile.decompiler")
	public DecompileImpl decompiler = DecompileImpl.CFR;

	// ============================ COMMON OPTIONS ============================ //

	/**
	 * Show synthetic members. Most decompilers will change formatting semantics as well with
	 * this, yielding less legible output.
	 */
	@Conf("decompile.showsynthetics")
	public boolean showSynthetic;

	/**
	 * Strip debug from class before it is sent to the decompiler.
	 * Useful when garbage data is inserted into debug attributes.
	 */
	@Conf("decompile.stripdebug")
	public boolean stripDebug;

	/**
	 * Determine if the decompiler name/version should be output.
	 */
	@Conf("decompile.showname")
	public boolean showName = true;

	/**
	 * Time to wait before aborting the decompile process.
	 */
	@Conf("decompile.timeout")
	public long timeout = 9000;

	// ============================ CFR OPTIONS ============================ //

	// TODO: Add cfr options

	// ========================= VINEFLOWER OPTIONS ======================== //

	// TODO: Add vf options
	// 		 别问为什么不继续写了 为什么没翻译 问就是写不动了:(
	@Conf("decompile.vf.remove_bridge")
	public boolean vfRemoveBridge = false;
	@Conf("decompile.vf.remove_synthetic")
	public boolean vfRemoveSynthetic = false;
	@Conf("decompile.vf.decompile_inner")
	public boolean vfDecompileInner = true;
	@Conf("decompile.vf.decompile_class_1_4")
	public boolean vfDecompileClass1_4 = true;
	@Conf("decompile.vf.decompile_assertions")
	public boolean vfDecompileAssertions = true;
	@Conf("decompile.vf.hide_empty_super")
	public boolean vfHideEmptySuper = true;
	@Conf("decompile.vf.hide_default_constructor")
	public boolean vfHideDefaultConstructor = true;
	@Conf("decompile.vf.decompile_generic_signatures")
	public boolean vfDecompileGenericSignatures = true;
	@Conf("decompile.vf.incorporate_returns")
	public boolean vfIncorporateReturns = true;

	// ========================= PROCYON OPTIONS ======================== //

	// TODO: Add procyon options

	ConfDecompile() {
		super("decompiler");
	}
}
