package norman.template;

public interface TemplateConst {
    /**
     * linux slash
	 */
	String LINUX_SLASH = "/";

	/**
	 * windows slash
	 */
	String WINDOWS_SLASH = "\\";

	/**
	 * simple dot
	 */
	String DOT = ".";

	/**
	 * to create complete location
	 */
	int INPUT = 1;
	int OUTPUT = 2;

	String defaultExt = "txt";


	/**
	 * Environment type
	 */
	int WINDOWS = 1;
	int LINUX = 2;
}
