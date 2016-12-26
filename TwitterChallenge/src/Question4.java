import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Question4 {
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String[] res;
        
        int _ip_size = 0;
        _ip_size = Integer.parseInt(in.nextLine().trim());
        String[] _ip = new String[_ip_size];
        String _ip_item;
        for(int _ip_i = 0; _ip_i < _ip_size; _ip_i++) {
            try {
                _ip_item = in.nextLine();
            } catch (Exception e) {
                _ip_item = null;
            }
            _ip[_ip_i] = _ip_item;
        }
        
        res = checkIP(_ip);
        for (int i = 0; i < res.length; i++) {
        	System.out.println(res[i]);
        }
    }

	static String[] checkIP(String[] ip) {
        String[] output = new String[ip.length];
		
		for (int i = 0; i < ip.length; i++) {
			output[i] = processIP(ip[i].toLowerCase());
		}
		
		return output;
    }

    private static String processIP(String string) {
		
        if (string.split("[.]").length == 4) {
            return processIPv4(string);
        } else if (string.split("[:]").length == 8) {
            return processIPv6(string);
        } else return "Neither";
	}

	private static String processIPv4(String string) {
        String[] components = string.split("[.]");
		for (int i = 0; i < 4; i++) {
			try {
				int component = Integer.parseInt(components[i]);
				if (component < 0 || component > 255) return "Neither"; 
			} catch (Exception e) {
				return "Neither";
			}
		}
		return "IPv4";
	} 

	private static String processIPv6(String string) {
        String[] components = string.split("[:]");
		for (int i = 0; i < components.length; i++) {
			String component = components[i];
			if (component.length() <= 4 && component.length() > 0) {
				for (int j = 0; j < component.length(); j++) {
					if (Character.digit(component.charAt(j), 16) == -1) {
						return "Neither";
					}
				}
			} else {
				return "Neither";
			}
		}
		return "IPv6";
	}
}
