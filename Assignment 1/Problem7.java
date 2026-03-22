// Demonstrate Inner Classes (member, local, anonymous) 

class OuterClass {

    // Member Inner Class
    class MemberInner {
        void display() {
            System.out.println("This is Member Inner Class");
        }
    }

    // Method containing Local Inner Class
    void showLocalClass() {

        // Local Inner Class
        class LocalInner {
            void display() {
                System.out.println("This is Local Inner Class");
            }
        }

        LocalInner local = new LocalInner();
        local.display();
    }

    // Method demonstrating Anonymous Inner Class
    void showAnonymousClass() {

        // Anonymous Inner Class using interface
        Runnable obj = new Runnable() {
            public void run() {
                System.out.println("This is Anonymous Inner Class");
            }
        };

        obj.run();
    }
}

public class Problem7 {
    public static void main(String[] args) {

        OuterClass outer = new OuterClass();

        // Member Inner Class
        OuterClass.MemberInner m = outer.new MemberInner();
        m.display();

        // Local Inner Class
        outer.showLocalClass();

        // Anonymous Inner Class
        outer.showAnonymousClass();
    }
}