# Steganography Lab

## Objective

The steganography lab project aimed to explore methods of covertly embedding data within digital media. The primary focus was to conceal a text file inside an image using WinRAR, while preserving the visual integrity of the original file. The lab leveraged the command line to compare file sizes, confirming the differences between the original and altered images. This hands-on experience was designed to deepen understanding of hidden data techniques and their relevance in cybersecurity analysis.

### Skills Learned

- Advanced understanding of steganography techniques and covert data embedding.
- Proficiency in using WinRAR to conceal information within digital media.
- Ability to utilize the command line to compare and analyze file properties.
- Enhanced knowledge of file structures, data integrity, and digital concealment methods.
- Development of critical thinking and problem-solving skills in detecting hidden data in cybersecurity contexts.

### Tools Used

- WinRAR for embedding and concealing text files within images.
- Command Prompt for comparing file sizes and analyzing file properties.
- Windows File Explorer for navigating directories and managing original and altered files.

## Steps
1. Created an empty folder “StegExample”, copied in a regular photo (pic1.jpg) to be used, and created a text file with secret message (SecretMessage.txt).
   
<img width="461" height="263" alt="Screenshot 2025-06-16 185530" src="https://github.com/user-attachments/assets/1803bc2b-33c9-447c-825d-8e58a23b67dc" />

2. Used WinRAR to compress SecretMessage.txt into SecretMessage.rar  
<img width="331" height="190" alt="Screenshot 2025-06-16 190057" src="https://github.com/user-attachments/assets/ddb60b24-f0c5-40ea-ac3d-a7e767f9ce34" />

3. Viewing the contents of the stegexample folder before and after using the "Copy /b pic1.jpg + SecretMessage.rar stegpic.jpg” command to copy the text file and image file into the new image file “stegpic.jpg”  
<img width="376" height="550" alt="Screenshot 2025-06-16 191013" src="https://github.com/user-attachments/assets/f099b599-66f7-499b-9ab0-bb964a7ccffe" />

Note: the images may look identical to the human eye but as we can see, stegpic.jpg is much larger in size than the original pic1.jpg image.

## Outcome
Original picture (pic1.jpg)

![pic1](https://github.com/user-attachments/assets/94190441-cc2a-47c9-aa1b-ccc82ed3ab7b)

Embedded image (stegpic.jpg)
![stegpic](https://github.com/user-attachments/assets/9fbb40c1-edee-4ddc-a827-85a482bf28d5)
