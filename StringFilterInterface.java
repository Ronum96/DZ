package Interface;

import java.util.List;
@FunctionalInterface
public interface StringFilterInterface {
    List<String> search(List<String> list);
}