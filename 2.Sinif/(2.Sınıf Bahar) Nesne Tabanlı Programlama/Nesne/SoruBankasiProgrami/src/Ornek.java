public class Ornek {
static int y = 0;
int z;
Ornek(){
z = 0;
}
Ornek(Ornek o){
z = o.z;
}
public void artirY() {
y++;
System.out.print(y+" ");
}
public void artirZ() {
z++;
System.out.print(z+" ");
}
}