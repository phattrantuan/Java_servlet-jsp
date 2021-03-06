package DAO;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MultiFileDAO {
	public static void Uploadsinglefile(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		ServletContext context = request.getServletContext();
	   String path=  context.getRealPath("/upLoad_Image_Audio/");
	
		
		final String Address = path;
		final int MaxMemorySize = 1024 * 1024 * 3; //3MB
		final int MaxRequestSize = 1024 * 1024 * 50; //50 MB
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (!isMultipart)
		{
			request.setAttribute("message","not have enctypr: multipart/form-data");	
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		
		// Set factory constraints
		factory.setSizeThreshold(MaxMemorySize);

		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		
		// Set overall request size constraint
		upload.setSizeMax(MaxRequestSize);
		
		
		
		try 
		{
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			
			while (iter.hasNext()) 
			{
			    FileItem item = iter.next();

			    if (!item.isFormField()) 
			    {
			    	 String fileName = item.getName();
			    	 
			    	 //pathFile: vị trí mà chúng ta muốn upload file vào
			    	 //gửi cho server
			    	 
			    	 String pathFile = Address + File.separator + fileName;
			    	 
			    	File uploadedFile = new File(pathFile);
			    	boolean kt = uploadedFile.exists();
			    	 
			    	try 
			    	{
			    		if (kt == true)
			    		{
			    			request.setAttribute("message","File "+fileName+" exist");		
			    		}
			    		else
			    		{
			    			item.write(uploadedFile);
							request.setAttribute("message","Upload file success");		
			    		}
						
						
					} 
			    	catch (Exception e) 
			    	{

			    		request.setAttribute("message",e.getMessage());	
						
					}
			    	 
			    	 
			    } 
			    else 
			    {
			    	request.setAttribute("message","Upload file failed");	
			    }
			}
			
		} 
		catch (FileUploadException e) 
		{
			if (e.getMessage()!=null)
			{
				request.setAttribute("message", e.getMessage());
			}
			
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Admin/homeAdmin.jsp");
		
		rd.forward(request,response);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void Uploadsinglefile_Vocabulary(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		ServletContext context = request.getServletContext();
	   String path=  context.getRealPath("/multifile_Vocabulary/");
	
		
		final String Address = path;
		final int MaxMemorySize = 1024 * 1024 * 3; //3MB
		final int MaxRequestSize = 1024 * 1024 * 50; //50 MB
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (!isMultipart)
		{
			request.setAttribute("message","not have enctypr: multipart/form-data");	
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		
		// Set factory constraints
		factory.setSizeThreshold(MaxMemorySize);

		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		
		// Set overall request size constraint
		upload.setSizeMax(MaxRequestSize);
		
		
		
		try 
		{
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			
			while (iter.hasNext()) 
			{
			    FileItem item = iter.next();

			    if (!item.isFormField()) 
			    {
			    	 String fileName = item.getName();
			    	 
			    	 //pathFile: vị trí mà chúng ta muốn upload file vào
			    	 //gửi cho server
			    	 
			    	 String pathFile = Address + File.separator + fileName;
			    	 
			    	File uploadedFile = new File(pathFile);
			    	boolean kt = uploadedFile.exists();
			    	 
			    	try 
			    	{
			    		if (kt == true)
			    		{
			    			request.setAttribute("message","File "+fileName+" exist");		
			    		}
			    		else
			    		{
			    			item.write(uploadedFile);
							request.setAttribute("message","Upload file success");		
			    		}
						
						
					} 
			    	catch (Exception e) 
			    	{

			    		request.setAttribute("message",e.getMessage());	
						
					}
			    	 
			    	 
			    } 
			    else 
			    {
			    	request.setAttribute("message","Upload file failed");	
			    }
			}
			
		} 
		catch (FileUploadException e) 
		{
			if (e.getMessage()!=null)
			{
				request.setAttribute("message", e.getMessage());
			}
			
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Admin/homeAdmin.jsp");
		rd.forward(request, response);
		
		
		
		
	}
}
