package PC;

import PC.CPU.*;
import PC.HardDisk.*;
import PC.EMS.*;

public class PC {
    private CPU cpu;
    private HardDisk hardDisk;
    private EMS ems;
    
    public PC(){

    }

    public PC(CPU cpu, HardDisk hardDisk, EMS ems) {
        this.cpu = cpu;
        this.hardDisk = hardDisk;
        this.ems = ems;
    }
    
    
    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public EMS getEms() {
        return ems;
    }

    public void setEms(EMS ems) {
        this.ems = ems;
    }

    public void showPCInfo() {
        cpu.showCPUInfo();
        hardDisk.showCapacity();
        ems.showEMSInfo();
    }
    
}
