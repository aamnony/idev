package com.github.amnonya.hdleditor.vhdl.ide.structureView;

import com.github.amnonya.hdleditor.vhdl.psi.VhdlFile;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;

import org.jetbrains.annotations.NotNull;

public class VhdlStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {
    public VhdlStructureViewModel(PsiFile psiFile) {
        super(psiFile, new VhdlStructureViewElement(psiFile));
    }

    @NotNull
    public Sorter[] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }


    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return element instanceof VhdlFile;
    }
}
