package pers.wzy.reggie.dto;

import pers.wzy.reggie.entity.Setmeal;
import pers.wzy.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
