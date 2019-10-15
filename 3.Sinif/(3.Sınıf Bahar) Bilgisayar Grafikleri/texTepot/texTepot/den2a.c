/*********************COMPLETALY OK***/


#include <stdlib.h>
//#include <stdio.h>
#include <glut.h>
#include <math.h>
#include "bitmap.c"	

BITMAPINFO *TexInfo; /* Texture bitmap information */
GLubyte    *TexBits; /* Texture bitmap pixel bits */


GLint spinx = 0;
GLint spiny = 0;


GLubyte *LoadDIBitmap(const char *filename,BITMAPINFO **info);    
void init(void) 
{
glEnable(GL_DEPTH_TEST);
glShadeModel(GL_SMOOTH);
glClearColor(0.0, 1.0, 1.0, 0.0);

glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
			glTexImage2D(GL_TEXTURE_2D, 0, 3, TexInfo->bmiHeader.biWidth,
					 TexInfo->bmiHeader.biHeight, 0, GL_BGR_EXT,
			 GL_UNSIGNED_BYTE, TexBits);
   glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
    glEnable(GL_TEXTURE_2D);
}/*end initial*/


void display (void)
{

   glClear (GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   glPushMatrix ();
   glRotatef ((GLfloat) spinx, 1.0, 0.0, 0.0);
   glRotatef ((GLfloat) spiny, 0.0, 0.0, 1.0);
		glutSolidTeapot(0.5f);
    glPopMatrix ();
    glFlush ();
}

/*  call when window is resized  */
void reshape(int w, int h)
{
    glViewport (0, 0, (GLsizei) w, (GLsizei) h);
   glMatrixMode (GL_PROJECTION);
   glLoadIdentity ();

   if (w <= h)
      glOrtho (-0.6, 0.6, -0.60*(GLfloat)h/(GLfloat)w,
         0.60*(GLfloat)h/(GLfloat)w, -0.60, 0.60);
   else
      glOrtho (-1.60*(GLfloat)w/(GLfloat)h,
         0.60*(GLfloat)w/(GLfloat)h, -0.60, 0.60, -0.60, 0.60);

   glMatrixMode(GL_MODELVIEW);  
}

/*  call when mouse button is prespringsed  */
void mouse(int button, int state, int x, int y) {
    switch (button) {
	case GLUT_LEFT_BUTTON:
	    switch (state) {
		case GLUT_DOWN:
		    spinx = (spinx + 5) % 360; 
                    glutPostRedisplay();
		    break;
		default:
		    break;
            }
            break;
	case GLUT_MIDDLE_BUTTON:
	    switch (state) {
		case GLUT_DOWN:
		    spiny = (spiny + 5) % 360; 
                    glutPostRedisplay();
		    break;
		default:
		    break;
            }
            break;
	case GLUT_RIGHT_BUTTON:
	    switch (state) {
		case GLUT_UP:
		    exit(0);
		    break;
		default:
		    break;
            }
            break;
        default:
            break;
    }
}



int main(int argc, char** argv)
{
TexBits = LoadDIBitmap("a1.bmp", &TexInfo);


    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB | GLUT_DEPTH);
glutInitWindowSize(500, 500);

    glutCreateWindow(argv[0]);
init();
    glutReshapeFunc(reshape);
    glutDisplayFunc(display);
    glutMouseFunc(mouse);

    glutMainLoop();
    return 0;
}



