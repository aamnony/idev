package com.github.aamnony.idev.vhdl.display;

import com.github.aamnony.idev.vhdl.lang.VhdlLabel;
import com.github.aamnony.idev.vhdl.lang.VhdlProcessStatement;
import com.github.aamnony.idev.vhdl.lang.VhdlRefname;
import com.github.aamnony.idev.vhdl.lang.VhdlSensitivityList;
import com.intellij.navigation.ItemPresentation;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

public class VhdlProcessPresentation implements ItemPresentation {
    private final VhdlProcessStatement process;

    public VhdlProcessPresentation(VhdlProcessStatement process) {
        this.process = process;
    }

    @Override
    public String getPresentableText() {
        String name = getName();

        List<String> sensitivityList = getSensitivityList();
        if (sensitivityList != null) {
            return String.format("%s(%s)", name, String.join(", ", sensitivityList));
        } else {
            return String.format("%s", name);
        }
    }

    @Nullable
    @Override
    public String getLocationString() {
        return null;
    }

    @Override
    public Icon getIcon(boolean unused) {
        return process.getIcon(0);
    }

    @Nullable
    private String getName() {
        List<VhdlLabel> labels = process.getLabelList();
        if (labels.isEmpty()) {
            return "process";
        } else {
            return labels.get(0).getIdentifier().getName();
        }
    }

    @Nullable
    private List<String> getSensitivityList() {
        VhdlSensitivityList list = process.getSensitivityList();
        if (list != null) {
            List<VhdlRefname> refnames = list.getRefnameList();
            List<String> names = new ArrayList<>(refnames.size());
            for (VhdlRefname vhdlRefname : refnames) {
                names.add(vhdlRefname.getText());
            }
            return names;
        }
        return null;
    }

}
