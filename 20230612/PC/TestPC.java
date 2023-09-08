package PC;
import PC.CPU.*;
import PC.HardDisk.*;
import PC.EMS.*;

public class TestPC {
    public static void main(String[] args) {
            
            //PC1
            System.out.println("PC1:");
            PC pc1 = new PC(new I9_13900k(),new Sandisk_5T(),new Kingston_8G());
            pc1.showPCInfo();
    
            System.out.println("====================================");
    
            //PC2
            System.out.println("PC2:");
            PC pc2 = new PC();
            pc2.setCpu(new R9_7950X());
            pc2.setHardDisk(new WDC_1T());
            pc2.setEms(new Lexar_16G());
            pc2.showPCInfo();

    }
}
