package com.github.amnonya.hdleditor.vhdl.navigation;

import com.github.amnonya.hdleditor.vhdl.VhdlIcons;
import com.github.amnonya.hdleditor.vhdl.psi.VhdlPackageDeclaration;
import com.intellij.navigation.ItemPresentation;

import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;

public class VhdlPackagePresentation implements ItemPresentation {
    private final VhdlPackageDeclaration declaration;

    public VhdlPackagePresentation(VhdlPackageDeclaration declaration) {
        this.declaration = declaration;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return declaration.getIdentifierList().get(0).getName();
    }

    @Nullable
    @Override
    public String getLocationString() {
        return null;
    }

    @Override
    public Icon getIcon(boolean unused) {
        return VhdlIcons.PACKAGE;
    }
}