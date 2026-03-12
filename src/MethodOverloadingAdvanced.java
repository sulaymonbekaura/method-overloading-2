public class MethodOverloadingAdvanced {

    // Logger: overloaded for different log types
    static void log(String message)               { System.out.println("[INFO]  " + message); }
    static void log(String message, String level) { System.out.println("["+level+"] " + message); }
    static void log(String message, Exception e)  { System.out.println("[ERROR] " + message + ": " + e.getMessage()); }
    static void log(int code, String message)     { System.out.println("[CODE " + code + "] " + message); }

    // Format: different types to String
    static String format(int n)             { return String.format("%,d", n); }
    static String format(double d)          { return String.format("%.4f", d); }
    static String format(double d, int decimals) { return String.format("%." + decimals + "f", d); }
    static String format(String s)          { return """ + s + """; }
    static String format(boolean b)         { return b ? "YES" : "NO"; }

    // Find: max of different arities
    static int    max(int a, int b)               { return Math.max(a, b); }
    static int    max(int a, int b, int c)        { return Math.max(a, Math.max(b,c)); }
    static double max(double... nums)             { double m=nums[0]; for(double n:nums) if(n>m) m=n; return m; }

    public static void main(String[] args) {
        System.out.println("=== Overloaded Logger ===");
        log("Application started");
        log("User logged in", "AUDIT");
        log("File not found", new RuntimeException("NoSuchFileException"));
        log(404, "Page not found");

        System.out.println("\n=== Overloaded format() ===");
        System.out.println(format(1234567));
        System.out.println(format(3.14159265));
        System.out.println(format(3.14159265, 2));
        System.out.println(format("hello"));
        System.out.println(format(true));

        System.out.println("\n=== Overloaded max() ===");
        System.out.println("max(3,7)     = " + max(3,7));
        System.out.println("max(3,7,5)   = " + max(3,7,5));
        System.out.println("max(1.5,9.9,3.3,7.1) = " + max(1.5,9.9,3.3,7.1));
    }
}
