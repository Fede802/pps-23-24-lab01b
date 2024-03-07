package e2.cell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClickableCellTest {


    private Clickable clickableCell;
    @BeforeEach
    void initClickableTest(){
        int cellX = 5;
        int cellY = 5;
        this.clickableCell = new ClickableCell(cellX,cellY);
    }

    @Test
    void isCellInitiallyUnselected(){
        assertFalse(this.clickableCell.isSelected());
    }

    @Test
    void selectCell(){
        this.clickableCell.click();
        assertTrue(this.clickableCell.isSelected());
    }

    @Test
    void deselectCell(){
        this.clickableCell.click();
        this.clickableCell.click();
        assertFalse(this.clickableCell.isSelected());
    }

    //todo test for multiple select/deselect cycles
}
