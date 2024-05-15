package shangxuetang.video;

import java.util.Objects;

public class p78 {
    public static void main(String[] args) {
        TestOverrideEquals t1 = new TestOverrideEquals(1);
        TestOverrideEquals t2 = new TestOverrideEquals(1);
        System.out.println(t1.equals(t2));
    }
}

class TestOverrideEquals {
    int id;

    TestOverrideEquals(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestOverrideEquals that = (TestOverrideEquals) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        } else if (obj instanceof TestOverrideEquals t) {
//            return t.id == this.id;
//        }
//        return false;
//    }
}